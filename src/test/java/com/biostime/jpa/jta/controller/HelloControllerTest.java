package com.biostime.jpa.jta.controller;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {
	@Resource
	private HelloController helloController;

}
