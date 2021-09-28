package com.example.filter.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



@Slf4j
// @Component
@WebFilter(urlPatterns = "/api/user/*") // 특정 클래스에만 필터를 사용하도록 설정하는 어노테이션
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //전처리

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse =new ContentCachingResponseWrapper((HttpServletResponse) response);


        chain.doFilter(httpServletRequest, httpServletResponse);

        //후처리

        String url = httpServletRequest.getRequestURI();

        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}",url,reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());

        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse(); // 다시 바디 내용을 채워넣어야 클라이언트가 응답내용을 확인할 수 있음.

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);
    }
}
