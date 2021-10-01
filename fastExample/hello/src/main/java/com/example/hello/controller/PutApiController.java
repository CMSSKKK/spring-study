package com.example.hello.controller;

import com.example.hello.dto.PostRequest;
import com.example.hello.dto.PostRequestForPut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestForPut put(@RequestBody PostRequestForPut requestDto,@PathVariable long userId) {
        System.out.println(userId);
        return requestDto;
    }


}
