package com.itheima.filter;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import com.alibaba.fastjson.JSON;
import com.itheima.entity.Result;
import com.itheima.utils.WarehouseConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//z
public class LoginCheckFilter implements Filter {
    private StringRedisTemplate redisTemplate;

    //构造器注入

    public void setRedisTemplate(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    //过滤器拦截请求的方法

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest ;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //判断有没有登录
        //JWT
        //白名单请求 直接放行
        List<String> urlList = new ArrayList<String>();
        urlList.add("/captcha/captchaImage");
        urlList.add("/login");
        urlList.add("/product/img-upload");
        //过滤器拦截到的当前的请求的URL接口
        String url = request.getServletPath();
        if (urlList.contains(url)||url.contains("/img/upload")){
            //是白名单 : 放行


            chain.doFilter(request,response);
            return ;

        }


        //其他请求都校验是否含有token 并且判断redis中是否含有token

        String token = request.getHeader(WarehouseConstants.HEADER_TOKEN_NAME);
        if (StringUtils.hasText(token) && redisTemplate.hasKey(token)){
            //有->放行
            chain.doFilter(request,response);
            return;
        }
        //没有 ->跳转到登录界面
        Map<String , Object> data = new HashMap<String , Object>();
        Result result = Result.err(Result.CODE_ERR_UNLOGINED, "您尚未登录");
        String jsonStr = JSON.toJSONString(result);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();

    }
}
