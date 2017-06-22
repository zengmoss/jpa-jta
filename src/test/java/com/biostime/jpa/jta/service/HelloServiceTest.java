package com.biostime.jpa.jta.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.biostime.jpa.jta.domain.oracle.IdentityCard;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
	@Resource
	private HelloService helloService;
	@Test
	public void saveId() throws Exception{
		IdentityCard i = new IdentityCard();
		i.setIdCardName("后知后觉");
		i.setIdCardNo("80502321");
		i.setCustomerId(80502321L);
		helloService.saveOracle();
		
	}
}
