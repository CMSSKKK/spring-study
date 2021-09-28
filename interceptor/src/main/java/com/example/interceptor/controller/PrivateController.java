package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Slf4j
@Auth // controller에 annotation으로 걸어두거나 위 url을 configuration에서 'addPathPatterns'하는 방법이 있다.
public class PrivateController {
    @GetMapping("/hello")
    public String hello(){
        log.info("private hello controller");
        return "private hello";
    }
}
