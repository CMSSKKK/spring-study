package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@RestController
@RequestMapping("/api/user")
@Validated
public class RestApiController {

    @GetMapping() // @RequestParam(required = false) parameter가 없어도 에러없이 null 값으로 받음
    public User get(
            @NotEmpty
            @Size(min = 2,max = 10)
            @RequestParam String name,

            @Min(1)
            @RequestParam Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10+age;

        return user;
    }

    @PostMapping()
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        System.out.println("api controller handler");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }
}
