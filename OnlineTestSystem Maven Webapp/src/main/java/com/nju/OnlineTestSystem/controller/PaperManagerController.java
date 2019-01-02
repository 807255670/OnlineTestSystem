package com.nju.OnlineTestSystem.controller;

import java.util.HashMap;
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
public class PaperManagerController {
	@Resource
	PaperService paperService;
	
	
	@RequestMapping("/papermanager")
	public String paperManager(HttpSession session,HttpServletRequest request){
		if (session.getAttribute("teacherprimarykey")==null){
			return "teacherlogin";
		}
		Integer teacherid= (Integer) session.getAttribute("teacherprimarykey");
		List<HashMap> paperlist=paperService.getAllPapersByTeacherPrimaryKey(teacherid);
		request.setAttribute("paperlist", paperlist);
		return "papermanager";
	}
}
