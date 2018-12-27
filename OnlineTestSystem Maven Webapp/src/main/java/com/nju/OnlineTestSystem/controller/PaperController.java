package com.nju.OnlineTestSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.service.PaperService;

@Controller
@RequestMapping(value = "/teacher")
public class PaperController {
	
	@Resource
	PaperService paperService;
	@Resource
	ClassService classService;
	
	@RequestMapping(value = "/paperList")
	public String showPapers(HttpSession session,HttpServletRequest request){
		
		//未登录或者会话过期 返回登录
		if(session.getAttribute("teacherid")==null){
			return "teacherlogin";
		}
		
		Integer classid;
		if(request.getParameter("classid")!=null){
			classid=Integer.parseInt(request.getParameter("classid"));
			String classname=classService.getClassNameByPrimaryKey(classid);
			session.setAttribute("classname", classname);
			session.setAttribute("classid",classid);
		}
		else if(session.getAttribute("classid")!=null){
			classid=(Integer) session.getAttribute("classid");
		}
		else{
			return "teacherlogin";
		}
		List<Paper> paperList=paperService.getAllPapersByClassPrimaryKey(classid);
		request.setAttribute("paperList", paperList);
		return "teacherindexpaper";
	}
	
	@RequestMapping(value = "/paperscorelist")
	public String showPaperScore(HttpSession session,HttpServletRequest request){
		
		if(session.getAttribute("teacherid")==null){
			return "teacherlogin";
		}
		
		Integer paperid;
		if(request.getParameter("paperid")!=null){
			paperid=Integer.parseInt(request.getParameter("paperid"));
			String papername=paperService.getPaperNameByPrimaryKey(paperid);
			session.setAttribute("papername", papername);
			session.setAttribute("paperid", paperid);
		}
		else if(session.getAttribute("paperid")!=null){
			paperid=(Integer) session.getAttribute("paperid");
		}
		else {
			return "teacherlogin";
		}
		List<HashMap> list=paperService.getStudentScoreByPaperPrimaryKey(paperid);
		System.out.println(list);
		request.setAttribute("scorelist", list);
		return "teacherindexpaperscore";
	}
}
