package com.nju.OnlineTestSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.nju.OnlineTestSystem.model.Class;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.service.PaperService;


@Controller
@RequestMapping(value = "/teacher")
public class PaperGenerateController {
	@Resource
	ClassService classService;
	@Resource
	PaperService paperService;
	
	@RequestMapping(value="/papergenerate")
	public String paperGenerate(HttpSession session,HttpServletRequest request){
		//未登录或者会话过期 返回登录
		if(session.getAttribute("teacherid")==null){
			return "teacherlogin";
		}
		return "papergenerate";
	}
	
	@RequestMapping(value="/papergenerate/getallclasses")
	@ResponseBody
	public List<Class> getAllClasses(HttpSession session,HttpServletRequest request){
		if(session.getAttribute("teacherid")==null){
			return null;
		}
		//System.out.println(session.getAttribute("teacherprimarykey"));
		Integer teacherid = (Integer) session.getAttribute("teacherprimarykey");
		List<Class> classlist= classService.getAllClassByTeacherPrimaryKey(teacherid);
		//System.out.println(classlist);
		return classlist;
	}
	
	@RequestMapping(value="/papergenerate/submit")
	@ResponseBody
	public boolean generatePaper(HttpSession session,HttpServletRequest request){
		String papername=request.getParameter("papername");
		String password=request.getParameter("password");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date deadtime=null;
		try {
			deadtime= sdf.parse(request.getParameter("deadtime"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String classname=request.getParameter("classname");
		Integer single = Integer.parseInt(request.getParameter("single"));
		Integer multiple = Integer.parseInt(request.getParameter("multiple"));
		Integer judge = Integer.parseInt(request.getParameter("judge"));
		Integer fill=Integer.parseInt(request.getParameter("fill"));
		Integer subject = Integer.parseInt(request.getParameter("subject"));
		Integer classid=classService.getPrimaryKeyByClassName(classname);
		return paperService.generatePaper(papername,password,deadtime,classid,single,multiple,judge,fill,subject);
	}
	
}
