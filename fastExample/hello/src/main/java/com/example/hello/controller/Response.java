package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/res")
public class Response {

    @PutMapping("/put")
    public ResponseEntity<UserDto> put(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
