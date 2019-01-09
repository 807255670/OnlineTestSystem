package com.nju.OnlineTestSystem.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nju.OnlineTestSystem.model.FillQuestion;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;
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
	@RequestMapping("/papermanagerlist")
	public String paperManegerList(HttpSession session,HttpServletRequest request){
		if (session.getAttribute("teacherprimarykey")==null){
			return "teacherlogin";
		}
		//System.out.println(request.getParameter("paperid"));
		Integer paperid=Integer.parseInt(request.getParameter("paperid"));
		List<SingleQuestion> singlequestions = paperService.getSingleQuestionsByPaperPrimaryKey(paperid);
		List<MultyQuestion> multyquestions=paperService.getMultyQuestionsByPaperPrimaryKey(paperid);
		List<JudgeQuestion> judgequestions=paperService.getJudgeQuestionsByPaperPrimaryKey(paperid);
		List<FillQuestion> fillquestions=paperService.getFillQuestionsByPaperPrimaryKey(paperid);
		List<SubjectQuestion> subjectquestions=paperService.getSubjectQuestionsByPaperPrimaryKey(paperid);
		String papername= paperService.getPaperNameByPrimaryKey(paperid);
		request.setAttribute("papername", papername);
		session.setAttribute("paperid", paperid);
		request.setAttribute("singlequestions", singlequestions);
		request.setAttribute("multyquestions", multyquestions);
		request.setAttribute("judgequestions", judgequestions);
		request.setAttribute("fillquestions", fillquestions);
		request.setAttribute("subjectquestions", subjectquestions);
		return "papermanagerlist";
	}
	@RequestMapping("/papermanagerlist/submit")
	@ResponseBody
	public String getEdit(HttpSession session,HttpServletRequest request){
		if (session.getAttribute("teacherprimarykey")==null){
			return "teacherlogin";
		}
		String spaperid=request.getParameter("paperid");
		String questiontype=request.getParameter("questiontype");
		String before = request.getParameter("before");
		String after = request.getParameter("after");
		Integer paperid=Integer.parseInt(spaperid);
		String questionids=null;
		if("a".equals(questiontype)){
			questionids=paperService.getSingleidsByPaperPrimaryKey(paperid);
		}
		else if("b".equals(questiontype)){
			questionids=paperService.getMultyidsByPaperPrimaryKey(paperid);
		}
		else if("c".equals(questiontype)){
			questionids=paperService.getJudgeidsByPaperPrimaryKey(paperid);		
		}
		else if("d".equals(questiontype)){
			questionids=paperService.getFillidsByPaperPrimaryKey(paperid);
		}
		else if("e".equals(questiontype)){
			questionids=paperService.getSubjectidsByPaperPrimaryKey(paperid);
		}
		if (questionids!=null){
			String[] aquestionids =questionids.split(",");
			for (int i=0;i<aquestionids.length;i++){
				if (aquestionids[i].equals(after)){
					return "1";
				}
				if(aquestionids[i].equals(before)){
					aquestionids[i]=after;
				}
			}
			if(!paperService.canBeAdded(Integer.parseInt(after),questiontype,paperid)){
				return "2";
			}
			questionids=String.join(",",aquestionids);
			paperService.updateQuestion(paperid,questiontype,questionids);
			return "3";
		}
		else{
			return "0";
		}
	}
	
	
	
	
}
