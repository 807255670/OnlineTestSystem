package com.nju.OnlineTestSystem.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.service.QuestionService;
import com.nju.OnlineTestSystem.model.Class;
import com.nju.OnlineTestSystem.model.FillQuestion;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;

@Controller
@RequestMapping(value = "/teacher")
public class QuestionmangerController {
	@Resource
	ClassService classService;
	@Resource
	QuestionService questionService;
	
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
	
	@RequestMapping(value="/getsinglequestionlist")
	@ResponseBody
	public List<SingleQuestion> singlequestionList(HttpServletRequest request,HttpSession session){
		
		Integer classid=Integer.parseInt((String) session.getAttribute("classid")) ;
		List<SingleQuestion> questionlist= questionService.getSingleQuestionsByClassPrimaryKey(classid);
		return questionlist;	
	}
	@RequestMapping(value="/getmultyquestionlist")
	@ResponseBody
	public List<MultyQuestion> multyquestionList(HttpServletRequest request,HttpSession session){
		
		Integer classid=Integer.parseInt((String) session.getAttribute("classid")) ;
		List<MultyQuestion> questionlist= questionService.getMultyQuestionsByClassPrimaryKey(classid);
		return questionlist;	
	}
	@RequestMapping(value="/getjudgequestionlist")
	@ResponseBody
	public List<JudgeQuestion> judgequestionList(HttpServletRequest request,HttpSession session){
		
		Integer classid=Integer.parseInt((String) session.getAttribute("classid")) ;
		List<JudgeQuestion> questionlist= questionService.getJudgeQuestionsByClassPrimaryKey(classid);
		return questionlist;	
	}
	@RequestMapping(value="/getfillquestionlist")
	@ResponseBody
	public List<FillQuestion> fillquestionList(HttpServletRequest request,HttpSession session){
		
		Integer classid=Integer.parseInt((String) session.getAttribute("classid")) ;
		List<FillQuestion> questionlist= questionService.getFillQuestionsByClassPrimaryKey(classid);
		return questionlist;	
	}
	@RequestMapping(value="/getsubjectquestionlist")
	@ResponseBody
	public List<SubjectQuestion> subjectquestionList(HttpServletRequest request,HttpSession session){
		
		Integer classid=Integer.parseInt((String) session.getAttribute("classid")) ;
		List<SubjectQuestion> questionlist= questionService.getSubjectQuestionsByClassPrimaryKey(classid);
		return questionlist;	
	}
	
	@RequestMapping(value="/questionlist")
	public String questionList(HttpSession session,HttpServletRequest request){
		
		if(session.getAttribute("teacherprimarykey")==null){
			return "teacherlogin";
		}
		session.setAttribute("classid",request.getParameter("classid") );
		return "questionmanagerlist";
	}
}
