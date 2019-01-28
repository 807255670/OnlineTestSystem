package com.nju.OnlineTestSystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.OnlineTestSystem.dto.ClassTag;
import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.service.StudentAccountService;

@Controller
@RequestMapping(value = "/student")
public class StudentAccountController {
	@Resource
	StudentAccountService studentAccountService;
	@Resource
	ClassService classService;
		
	@RequestMapping(value = "")
	public String welcome(HttpSession session,HttpServletRequest request){
		
		//查找会话，判断是否已登录
		if(session.getAttribute("studentid")!=null){
			//从会话中获得登录账号  即工号，非主键
			String loginid=session.getAttribute("studentid").toString(); 
			//根据登录账号获得主键
			Integer studentPrimaryKey = studentAccountService.getPrimaryKeyByLoginId(loginid);
			//根据主键获得课程列表
			List<ClassTag> classes = classService.findAllClassByStudentPrimaryKey(studentPrimaryKey);
			request.setAttribute("classes", classes);
			return "student_classes_list";
		}
		return "studentlogin";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST )
	public String login(HttpSession session,HttpServletRequest request){
		String username=request.getParameter("id");  //登录账号，即工号 ，非主键
		String password=request.getParameter("pwd");
		boolean loginsuccess=studentAccountService.login(username, password);
		//如果登录成功
		if(loginsuccess){
			String studentName=studentAccountService.getNameByLoginId(username); //姓名
			Integer studentPrimaryKey = studentAccountService.getPrimaryKeyByLoginId(username);//获得主键
			
			//根据学生主键查找课程
			List<ClassTag> classes = classService.findAllClassByStudentPrimaryKey(studentPrimaryKey);
			request.setAttribute("classes", classes);
			session.setAttribute("studentPrimaryKey", studentPrimaryKey);
			session.setAttribute("studentid", username);//工号
			session.setAttribute("studentName", studentName); //姓名
			session.setMaxInactiveInterval(6000); //会话最长6000s
			return "student_classes_list";
		}
		return "studentlogin";
	}
}
