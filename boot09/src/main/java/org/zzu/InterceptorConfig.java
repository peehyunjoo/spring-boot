package org.zzu;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zzu.interceptor.LoginCheckInterceptor;

import lombok.extern.java.Log;

@Configuration
@Log
public class InterceptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/login");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
