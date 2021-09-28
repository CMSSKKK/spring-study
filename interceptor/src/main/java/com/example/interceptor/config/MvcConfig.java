package com.example.interceptor.config;


import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor // final로 선언된 개체를 주입받도록 함
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
        //registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*"); //exculdePathPatterns
    }
}
