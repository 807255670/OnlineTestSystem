package com.nju.OnlineTestSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController {
	//学生端的url以/student开头，教师端的以/teacher开头，
	//这个testController类为测试环境是否搭建成功的类，看懂即可删除
	@RequestMapping(value = "/")
	public String index(){
		return "index";
	}

	
}
