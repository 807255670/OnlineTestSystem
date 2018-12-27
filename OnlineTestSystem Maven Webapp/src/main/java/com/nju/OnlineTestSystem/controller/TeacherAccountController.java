package com.nju.OnlineTestSystem.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.service.TeacherAccountService;
import com.nju.OnlineTestSystem.model.Class;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherAccountController {

	@Resource
	TeacherAccountService teacherAccountService;
	@Resource
	ClassService classService;
		
	@RequestMapping(value = "")
	public String welcome(HttpSession session,HttpServletRequest request){
		
		//查找会话，判断是否已登录
		if(session.getAttribute("teacherid")!=null){
			//从会话中获得登录账号  即工号，非主键
			String loginid=session.getAttribute("teacherid").toString(); 
			//根据登录账号获得主键
			Integer teacherPrimaryKey = teacherAccountService.getPrimaryKeyByLoginId(loginid);
			//根据主键获得课程列表
			List<Class> classList=classService.getAllClassByTeacherPrimaryKey(teacherPrimaryKey);
			request.setAttribute("classList", classList);
			return "teacherindex";
		}
		return "teacherlogin";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST )
	public String login(HttpSession session,HttpServletRequest request){
		String username=request.getParameter("id");  //登录账号，即工号 ，非主键
		String password=request.getParameter("pwd");
		boolean loginsuccess=teacherAccountService.login(username, password);
		//如果登录成功
		if(loginsuccess){
			String teachername=teacherAccountService.getNameByLoginId(username); //姓名
			Integer teacherPrimaryKey = teacherAccountService.getPrimaryKeyByLoginId(username);//获得主键
			
			//根据教师主键查找课程列表
			List<Class> classList=classService.getAllClassByTeacherPrimaryKey(teacherPrimaryKey);
			request.setAttribute("classList", classList);
			session.setAttribute("teacherprimarykey", teacherPrimaryKey);
			session.setAttribute("teacherid", username);//工号
			session.setAttribute("teachername", teachername); //姓名
			session.setMaxInactiveInterval(6000); //会话最长6000s
			return "teacherindex";
		}
		return "teacherlogin";
	}

	
}
