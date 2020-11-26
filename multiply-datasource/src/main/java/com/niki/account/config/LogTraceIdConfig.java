package com.niki.account.config;

import com.niki.account.interceptor.LogTraceIdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LogTraceIdConfig implements WebMvcConfigurer {
    @Bean
    public LogTraceIdInterceptor getLogTraceIdInterceptor() {
        return new LogTraceIdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLogTraceIdInterceptor()).addPathPatterns("/*");
    }
}
