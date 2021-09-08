package com.example.hello.controller;

import com.example.hello.dto.PostRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequest postRequest) {
        System.out.println(postRequest.toString());

    }


}
