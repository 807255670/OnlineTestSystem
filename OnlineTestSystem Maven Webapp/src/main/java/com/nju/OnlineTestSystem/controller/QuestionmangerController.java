package com.nju.OnlineTestSystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.model.Class;

@Controller
@RequestMapping(value = "/teacher")
public class QuestionmangerController {
	@Resource
	ClassService classService;
	@RequestMapping(value="/questionmanager")
	public String questionManager(HttpSession session,HttpServletRequest request){
		if (session.getAttribute("teacherprimarykey")==null){
			return "teacherlogin";
		}
		Integer teacherid= (Integer) session.getAttribute("teacherprimarykey");
		List<Class> classlist= classService.getAllClassByTeacherPrimaryKey(teacherid);
		request.setAttribute("classlist", classlist);
		return "questionmanager";
	}
}
