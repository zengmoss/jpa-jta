package com.biostime.jpa.jta.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.biostime.jpa.jta.domain.mysql.Mama100GrouponActivity;
import com.biostime.jpa.jta.domain.oracle.IdentityCard;
import com.biostime.jpa.jta.repository.mysql.GrouponActivityRepository;
import com.biostime.jpa.jta.repository.oracle.IdentityCardRepository;

@Service
public class HelloService {

	@Resource
	private IdentityCardRepository identityCardRepository;
	@Resource
	private GrouponActivityRepository grouponActivityRepository;
	public String say(String name) {
		return "Hello " + name;
	}

	@Transactional
	public IdentityCard saveOracle() {
		IdentityCard i = new IdentityCard();
		i.setIdCardName("后知后觉");
		i.setIdCardNo("80502321");
		i.setCustomerId(80502321L);
		identityCardRepository.save(i);
		// throw new RuntimeException();
		return i;
	}

	@Transactional
	public Mama100GrouponActivity saveMysql() {
		Mama100GrouponActivity m = new Mama100GrouponActivity();
		m.setActivityCode("123456");
		m.setName("saveMysql");
		m.setPlatformType(1);
		m.setSku(100L);
		m.setPrice(12.5D);
		m.setNum(5);
		m.setDuration(24);
		m.setStatus(0);
		m.setActivityCode("123456");
		grouponActivityRepository.save(m);
		// throw new RuntimeException();
		return m;
	}

	@Transactional
	public void saveAllYes() {
		IdentityCard i = new IdentityCard();
		i.setIdCardName("后知后觉");
		i.setIdCardNo("80502321");
		i.setCustomerId(80502321L);
		identityCardRepository.save(i);
		Mama100GrouponActivity m = new Mama100GrouponActivity();
		m.setActivityCode("123456");
		m.setName("saveMysql");
		m.setPlatformType(1);
		m.setSku(100L);
		m.setPrice(12.5D);
		m.setNum(5);
		m.setDuration(24);
		m.setStatus(0);
		m.setActivityCode("123456");
		grouponActivityRepository.save(m);
	}
	@Transactional
	public IdentityCard saveAllNo() {
		IdentityCard i = new IdentityCard();
		i.setIdCardName("后知后觉");
		i.setIdCardNo("80502321");
		i.setCustomerId(80502321L);
		identityCardRepository.save(i);
		Mama100GrouponActivity m = new Mama100GrouponActivity();
		m.setActivityCode("123456");
		m.setName("saveMysql");
		m.setPlatformType(1);
		m.setSku(100L);
		m.setPrice(12.5D);
		m.setNum(5);
		m.setDuration(24);
		m.setStatus(0);
		m.setActivityCode("123456");
		grouponActivityRepository.save(m);
		throw new RuntimeException();
	}

	public IdentityCard findId() {
		return identityCardRepository.findOne(14544L);
	}
}
