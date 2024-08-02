package com.newtong.shortlink.admin.config;

import com.newtong.shortlink.admin.common.biz.user.UserTransmitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author NewTong
 * @Date 2024/8/2 -8:47
 * @Description
 */
@Configuration
public class UserConfiguration {
    @Bean
    public FilterRegistrationBean<UserTransmitFilter> userTransmitFilter(StringRedisTemplate redisTemplate) {
        FilterRegistrationBean<UserTransmitFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new UserTransmitFilter(redisTemplate));
        registration.addUrlPatterns("/*");
        registration.setOrder(0);
        return registration;
    }
}
