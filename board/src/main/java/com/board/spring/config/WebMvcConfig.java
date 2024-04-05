package com.board.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.spring.interceptor.PreLoggingInterceptor;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {
	   @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new PreLoggingInterceptor())
	       .excludePathPatterns("/css/**", "/images/**", "/js/**");
	    }
}
