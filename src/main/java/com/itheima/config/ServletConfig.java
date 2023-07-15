package com.itheima.config;

import com.itheima.filter.LoginCheckFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;


@Configuration
public class ServletConfig {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {




        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();



        LoginCheckFilter loginCheckFilter = new LoginCheckFilter();

        loginCheckFilter.setRedisTemplate(stringRedisTemplate);

        filterRegistrationBean.setFilter( loginCheckFilter);


        filterRegistrationBean.addUrlPatterns("/*");


        return filterRegistrationBean;
    }


}
