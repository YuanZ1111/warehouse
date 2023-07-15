package com.itheima.controller;

import com.google.code.kaptcha.Producer;
import com.itheima.entity.CurrentUser;
import com.itheima.entity.LoginUser;
import com.itheima.entity.Result;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.utils.DigestUtil;
import com.itheima.utils.TokenUtils;
import com.itheima.utils.WarehouseConstants;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController

public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource(name = "captchaProducer")
    private Producer producer;
    @RequestMapping("/captcha/captchaImage")
//操作原生select
    public void captchaImage(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = null;
//生成文本
        try {
            String text = producer.createText();
//使用验证码文本生成验证码图片
            BufferedImage image = producer.createImage(text);
            //验证码文本保存到Redis
            redisTemplate.opsForValue().set(text, "", 3600, TimeUnit.SECONDS);
            response.setContentType("image/jpeg");
            outputStream = response.getOutputStream();

            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }

        }
//刷新





    @PostMapping("/login")
    public Result login(@RequestBody LoginUser loginUser) {

        String code = loginUser.getVerificationCode();
        Boolean flag = redisTemplate.hasKey(code);
        if (!flag) {
            return Result.err(Result.CODE_ERR_BUSINESS, "验证码错误");
        }




        User user = userService.queryUserByCode(loginUser.getUserCode());

        if (user != null) {
            if (user.getUserState().equals(WarehouseConstants.USER_STATE_PASS)) {
                //校
                String userPwd = loginUser.getUserPwd();
                userPwd = DigestUtil.hmacSign(userPwd);
                if (userPwd.equals(user.getUserPwd())) {
                    //合法
                    //登录 ---> JWT
                    CurrentUser currentUser = new CurrentUser(
                            user.getUserId(), user.getUserCode(), user.getUserName()
                    );
//生产token并且存到redis
                    String token = tokenUtils.loginSign(currentUser, userPwd);
                    //向客户端响应jwttoken

                    return Result.ok("登录成功", token);

                } else {
                    //非法
                    return Result.err(Result.CODE_ERR_BUSINESS, "密码错误");
                }
            } else {
                return Result.err(Result.CODE_ERR_BUSINESS, "该用户未通过审核无法登陆");
            }

        } else {
            return Result.err(Result.CODE_ERR_BUSINESS, "账号不存在");
        }
    }




    @GetMapping("/curr-user")
    public Result currentUser(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME
    ) String token) {
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        return Result.ok(currentUser) ;

    }




}
