package com.itheima.controller;

import com.google.code.kaptcha.Producer;
import com.itheima.entity.LoginUser;
import com.itheima.entity.Result;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.utils.WarehouseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController

public class LoginController {

    @Autowired
    private UserService userService;


    @Resource(name = "captchaProducer")
    private Producer producer;
    @Autowired

    private StringRedisTemplate redisTemplate;

    @RequestMapping("/captcha/captchaImage")
//操作原生select
    public void captchaImage(HttpServletResponse response) throws IOException {
//生成文本
        String text = producer.createText();
//使用验证码文本生成验证码图片

        BufferedImage image = producer.createImage(text);

        //验证码文本保存到Redis

        redisTemplate.opsForValue().set(text, "", 3600, TimeUnit.SECONDS);


        response.setContentType("image/jpeg");

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
//刷新


    }


    @RequestMapping("/login")
    public Result login(@RequestBody LoginUser loginUser)
    {



return null ;

    }


}
