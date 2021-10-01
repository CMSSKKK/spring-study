package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/get")
public class GetApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(path ="hi",method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }

//    @GetMapping("/path-variable/{name}") // 일치
//    public String pathVariable(@PathVariable String name) {
//        System.out.println("pathVariable : " +name);
//        return name;
//    }

    @GetMapping("/path-variable/{id}") // pathVariable과 변수를 다르게 설정해야 할때
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        System.out.println("pathVariable : " +pathName);
        return pathName;
    }

    @GetMapping("query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam ) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();

            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append('\n');
        });
        return sb.toString();
    }

    @GetMapping(path = "/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
