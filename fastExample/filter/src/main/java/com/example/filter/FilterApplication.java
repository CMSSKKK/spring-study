package com.example.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // WebFilter WebListener WebServlet 어노테이션을 사용하기위함  +스프링부트 내장 톰캣을 사용하여만 사용 가능하다
public class FilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterApplication.class, args);
	}

}
