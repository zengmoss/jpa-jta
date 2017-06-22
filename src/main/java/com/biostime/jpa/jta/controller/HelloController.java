package com.biostime.jpa.jta.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biostime.jpa.jta.domain.mysql.Mama100GrouponActivity;
import com.biostime.jpa.jta.domain.oracle.IdentityCard;
import com.biostime.jpa.jta.response.BaseGrouponRes;
import com.biostime.jpa.jta.service.HelloService;

@RestController
public class HelloController {
	@Resource
	private HelloService helloService;
	@RequestMapping(value = "/hello/saveOracle",method = RequestMethod.GET)
	public BaseGrouponRes<IdentityCard> saveId() throws Exception{
		BaseGrouponRes<IdentityCard> res = new BaseGrouponRes<>();
		res.setData(helloService.saveOracle());
		return res;
	}
	@RequestMapping(value = "/hello/saveMysql",method = RequestMethod.GET)
	public BaseGrouponRes<Mama100GrouponActivity> saveMysql() throws Exception{
		BaseGrouponRes<Mama100GrouponActivity> res = new BaseGrouponRes<>();
		res.setData(helloService.saveMysql());
		return res;
	}
	@RequestMapping(value = "/hello/saveAllYes",method = RequestMethod.GET)
	public BaseGrouponRes<IdentityCard> saveAllYes() throws Exception{
		BaseGrouponRes<IdentityCard> res = new BaseGrouponRes<>();
		helloService.saveAllYes();
		return res;
	}
	@RequestMapping(value = "/hello/saveAllNo",method = RequestMethod.GET)
	public BaseGrouponRes<IdentityCard> saveAllNo() throws Exception{
		BaseGrouponRes<IdentityCard> res = new BaseGrouponRes<>();
		try {
			helloService.saveAllNo();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	@RequestMapping(value = "/hello/findId",method = RequestMethod.GET)
	public BaseGrouponRes<IdentityCard> findId() throws Exception{
		BaseGrouponRes<IdentityCard> res = new BaseGrouponRes<>();
		res.setData(helloService.findId());
		return res;
	}
	
	
}
