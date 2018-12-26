package com.nju.OnlineTestSystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.service.PaperService;

@Controller
@RequestMapping(value = "/teacher")
public class PaperController {
	
	@Resource
	PaperService paperService;
	
	@RequestMapping(value = "/paperList")
	public String showPapers(HttpSession session,HttpServletRequest request){
		Integer classid=Integer.parseInt(request.getParameter("classid"));
		List<Paper> paperList=paperService.getAllPapersByClassPrimaryKey(classid);
		request.setAttribute("paperList", paperList);
		return "teacherindexpaper";
	}
}
