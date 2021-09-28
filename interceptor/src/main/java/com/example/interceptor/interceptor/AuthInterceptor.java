package com.example.interceptor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private boolean hasAnnotation(Object handler, Class clazz) {
        return false;
    }
}
