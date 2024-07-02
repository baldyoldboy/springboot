package com.user.aop;

import com.user.aop.service.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson6AopApplicationTests {

	@Autowired
	private SomeService someService;
	@Test
	void contextLoads() {
		someService.query(1);
		someService.save("张三", "21");
	}

}
