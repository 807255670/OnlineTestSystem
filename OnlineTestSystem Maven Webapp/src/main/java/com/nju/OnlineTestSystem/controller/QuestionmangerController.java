package com.nju.OnlineTestSystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nju.OnlineTestSystem.service.ClassService;
import com.nju.OnlineTestSystem.service.QuestionService;
import com.nju.OnlineTestSystem.util.ExcelUtil;
import com.nju.OnlineTestSystem.util.QuestionInput;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	@Resource
	ExcelUtil excelUtil;

	
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
	
	@RequestMapping(value="/import")
	public String getImportPage(HttpSession session,HttpServletRequest request){
		if(session.getAttribute("teacherprimarykey")==null){
			return "teacherlogin";
		}
		return "import";
	}
	@RequestMapping(value="/import",method = RequestMethod.POST)
	public String upload(@RequestParam MultipartFile[] upfile,Model model,HttpServletRequest request) throws IOException{
		String fileName = upfile[0].getOriginalFilename();
		String path = request.getScheme()+"://"+request.getServerName()+":"+  request.getServerPort()+request.getContextPath()+"/";
		File file = new File("F:/",fileName.split("\\.")[0]+new Date().getTime()+".xls");
		upfile[0].transferTo(file);
		List<SingleQuestion> list = excelUtil.readQuestionExcel(file);
		
		model.addAttribute("path", path);
		model.addAttribute("questionList",list);
		file.delete();
		return "import";
	}
	@RequestMapping(value="/import/submit",method = RequestMethod.POST)
	@ResponseBody
	public boolean submitQuestion(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = request.getParameter("myData");
		ObjectMapper objectMapper = new ObjectMapper();
		QuestionInput input = objectMapper.readValue(jsonStr, QuestionInput.class);
		boolean result = questionService.saveQuestionList(input.getQuestionList());
		return result;
	}
}
