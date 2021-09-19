package com.example.hello;

import com.example.hello.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("------------------------");

		var objectMapper = new ObjectMapper();

		var user = new UserDto("steve",10,"010-1111-2222");
		// object -> text
		// get method가 꼭 필요하다.
		// 또한 objectMapper가 참조하는 클래스에는 getter 이외에 get이 이름에 포함되는 메서드를 생성하지 말아야 한다.
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		// text -> object
		// defalut constructer가 꼭 필요하다.
		var objectUser = objectMapper.readValue(text, UserDto.class);
		System.out.println(objectUser);
	}

}
