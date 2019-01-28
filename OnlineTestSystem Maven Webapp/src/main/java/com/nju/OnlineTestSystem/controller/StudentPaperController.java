package com.nju.OnlineTestSystem.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nju.OnlineTestSystem.dto.FillQuestionDto;
import com.nju.OnlineTestSystem.dto.PaperScoreDto;
import com.nju.OnlineTestSystem.dto.PaperSummary;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;
import com.nju.OnlineTestSystem.score.*;
import com.nju.OnlineTestSystem.service.PaperService;
import com.nju.OnlineTestSystem.service.StudentAccountService;

/*
 * author: Liu Kangxin
 * */
@Controller
@RequestMapping(value = "/student")
public class StudentPaperController {
	@Resource
	private PaperService paperService;
	@Resource
	private StudentAccountService studentService;
	
	@RequestMapping(value = "/papers")
	public String papers(HttpSession session,HttpServletRequest request){
		String studentid = (String) session.getAttribute("studentid");
		if(studentid ==null){
			return "studentlogin";
		}
		try{
			Integer classid = Integer.parseInt(request.getParameter("classid"));
			session.setAttribute("classid", classid);
			Integer studentPrimaryKey = studentService.getPrimaryKeyByLoginId(studentid);
			List<PaperSummary> papers = paperService.findPapersByClassidAndStudentPK(studentPrimaryKey, classid);
			request.setAttribute("papers", papers);	
			return "student_paper_list";
		}catch(Exception exception){
			exception.printStackTrace();
			return "studentlogin";
		}
	}
	
	@RequestMapping(value = "/papers/{paperid}")
	public String getPaper(@PathVariable(value = "paperid") String pid,
							@RequestParam(value = "password") String password,
							HttpSession session,
							HttpServletRequest request,
							Model model){
		String studentid = (String) session.getAttribute("studentid");
		if(studentid ==null){
			return "studentlogin";
		}
		password = password == null ? "" : password;
		try{
			Integer paperid = Integer.parseInt(pid);
			Paper paper = paperService.selectByPrimaryKey(paperid);
			if(paper.getPassword().compareTo(password) != 0) throw new Exception("口令错误!");
			List<SingleQuestion> singleQuestions = paperService.getSingleQuestionsByPaperPrimaryKey(paperid);
			List<MultyQuestion> multyQuestions = paperService.getMultyQuestionsByPaperPrimaryKey(paperid);
			List<JudgeQuestion> judgeQuestions = paperService.getJudgeQuestionsByPaperPrimaryKey(paperid);
			List<FillQuestionDto> fillQuestions = paperService.getFillQuestionsDtoByPaperPrimaryKey(paperid);
			List<SubjectQuestion> subjectQuestions = paperService.getSubjectQuestionsByPaperPrimaryKey(paperid);
			model.addAttribute("singleQuestions",singleQuestions);
			model.addAttribute("multyQuestions", multyQuestions);
			model.addAttribute("judgeQuestions", judgeQuestions);
			model.addAttribute("fillQuestions", fillQuestions);
			model.addAttribute("subjectQuestions", subjectQuestions);
	        model.addAttribute("paperid",paperid);
	        model.addAttribute("paperName",paperService.getPaperNameByPrimaryKey(paperid));
	        return "answer";
		}catch(Exception exception){
			System.out.println(exception.getMessage());
			Integer classid = (Integer) session.getAttribute("classid");
			Integer studentPrimaryKey = studentService.getPrimaryKeyByLoginId(studentid);
			List<PaperSummary> papers = paperService.findPapersByClassidAndStudentPK(studentPrimaryKey, classid);
			request.setAttribute("papers", papers);	
			return "student_paper_list";
		}
	}
	
	@RequestMapping(value = "/paper/submit",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitAnswers(HttpSession session,@RequestBody Map<String, Object> req){
		String studentid = (String) session.getAttribute("studentid");
		if(studentid == null){
			return null;
		}
		
		Integer paperid = (Integer)req.get("paperid");
		Paper paper = paperService.selectByPrimaryKey(paperid);
		Date deadtime = paper.getDeadtime();
		Map<String, Object> response = new LinkedHashMap<>();
		if(new Date().getTime() > deadtime.getTime()){
			response.put("TLE","true");
			return response;
		}
		Integer studentPrimaryKey = studentService.getPrimaryKeyByLoginId(studentid);
		
		List singleAnswers = (List)req.get("singleAnswers");
		List multipleAnswers = (List)req.get("multipleAnswers");
		List judgementAnswers = (List)req.get("judgementAnswers");
		List fillAnswers = (List)req.get("fillAnswers");
		List subjectAnswers = (List)req.get("subjectAnswers");
		
		List singleStandardAnswers = paperService.getSingleQuestionsByPaperPrimaryKey(paperid);
		List multyStandardAnswers = paperService.getMultyQuestionsByPaperPrimaryKey(paperid);
		List judgeStandardAnswers = paperService.getJudgeQuestionsByPaperPrimaryKey(paperid);
		List fillStandardAnswers = paperService.getFillQuestionsDtoByPaperPrimaryKey(paperid);
		List subjectStandardAnswers = paperService.getSubjectQuestionsByPaperPrimaryKey(paperid);
		
		CorrectingAnswer singleMachine = new CorrectingSingleAnswer();
		CorrectingAnswer multyMachine = new CorrectingMultyAnswer();
		CorrectingAnswer judgeMachine = new CorrectingJudgeAnswer();
		CorrectingAnswer fillMachine = new CorrectingFillAnswer();
		CorrectingAnswer subjectMachine = new CorrectingSubjectAnswer();
		
		double singleScore = singleMachine.correct(singleAnswers, singleStandardAnswers);
		double multyScore = multyMachine.correct(multipleAnswers, multyStandardAnswers);
		double judgeScore = judgeMachine.correct(judgementAnswers, judgeStandardAnswers);
		double fillScore = fillMachine.correct(fillAnswers, fillStandardAnswers);
		double subjectScore = subjectMachine.correct(subjectAnswers, subjectStandardAnswers);
		
		PaperScoreDto paperScoreDto = new PaperScoreDto();
		paperScoreDto.setStudentPrimaryKey(studentPrimaryKey);
		paperScoreDto.setPaperid(paperid);
		paperScoreDto.setAnserdate(new Date());
		paperScoreDto.setSingleScore(Integer.valueOf((int)singleScore));
		paperScoreDto.setMultyScore(Integer.valueOf((int)multyScore));
		paperScoreDto.setJudgeScore(Integer.valueOf((int)judgeScore));
		paperScoreDto.setFillScore(Integer.valueOf((int)fillScore));
		paperScoreDto.setSubjectScore(Integer.valueOf((int)subjectScore));
		
		paperService.insertScoreByPaperScore(paperScoreDto);
		int score_total = 0;
		score_total += (int)singleScore;
		score_total += (int)multyScore;
		score_total += (int)judgeScore;
		score_total += (int)fillScore;
		score_total += (int)subjectScore;
        response.put("score_total", score_total);
        response.put("studentid", studentid);
        response.put("classid", session.getAttribute("classid"));
        return response;
	}
}
