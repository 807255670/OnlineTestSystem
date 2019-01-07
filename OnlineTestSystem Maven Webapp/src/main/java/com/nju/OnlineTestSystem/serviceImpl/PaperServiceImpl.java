package com.nju.OnlineTestSystem.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.mapper.ClassMapper;
import com.nju.OnlineTestSystem.mapper.FillQuestionMapper;
import com.nju.OnlineTestSystem.mapper.JudgeQuestionMapper;
import com.nju.OnlineTestSystem.mapper.MultyQuestionMapper;
import com.nju.OnlineTestSystem.mapper.PaperMapper;
import com.nju.OnlineTestSystem.mapper.SingleQuestionMapper;
import com.nju.OnlineTestSystem.mapper.StudentMapper;
import com.nju.OnlineTestSystem.mapper.SubjectQuestionMapper;
import com.nju.OnlineTestSystem.model.FillQuestion;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;
import com.nju.OnlineTestSystem.service.PaperService;

@Service("PaperService")
public class PaperServiceImpl implements PaperService{
	
	@Resource
	PaperMapper paperMapper;
	@Resource
	StudentMapper studentMapper;
	@Resource
	ClassMapper classMapper;
	@Resource
	SingleQuestionMapper singleQuestionMapper;
	@Resource
	MultyQuestionMapper multyQuestionMapper;
	@Resource
	JudgeQuestionMapper judgeQuestionMapper;
	@Resource
	FillQuestionMapper fillQuestionMapper;
	@Resource
	SubjectQuestionMapper subjectQuestionMapper;
	
	@Override
	public List<Paper> getAllPapersByClassPrimaryKey(Integer classid) {
		// TODO Auto-generated method stub
		List<Paper> paperList=paperMapper.selectByClassPrimaryKey(classid);
		return paperList;
	}

	@Override
	public List<HashMap> getStudentScoreByPaperPrimaryKey(Integer paperid) {
		
		List<HashMap> students=studentMapper.selectStudentScoreByPaperPrimaryKey(paperid);
		for (HashMap eachmap:students){
			Integer score1=(Integer) eachmap.get("singlescore");
			Integer score2=(Integer) eachmap.get("multyscore");
			Integer score3=(Integer) eachmap.get("judgescore");
			Integer score4=(Integer) eachmap.get("fillscore");
			Integer score5=(Integer) eachmap.get("subjectscore");
			if(score1==null){
				score1=0;
			}
			if(score2==null){
				score2=0;
			}
			if(score3==null){
				score3=0;
			}
			if(score4==null){
				score4=0;
			}
			if(score5==null){
				score5=0;
			}
			eachmap.put("score", score1+score2+score3+score4+score5);
		}
		return students;
	}

	@Override
	public String getPaperNameByPrimaryKey(Integer id) {
		Paper p=paperMapper.selectByPrimaryKey(id);
		return p.getName();
	}

	@Override
	public List<HashMap> getAllPapersByTeacherPrimaryKey(Integer teacherid) {
		List<HashMap> listmap = new ArrayList<>();
		List<Paper> list=paperMapper.selectByTeacherPrimaryKey(teacherid);
		for(Paper paper:list){
			HashMap<String, Object> map=new HashMap<>();
			Integer classid=paper.getClassid();
			String classname=classMapper.selectByPrimaryKey(classid).getName();
			map.put("paperid", paper.getId());
			map.put("classname",classname);
			map.put("papername",paper.getName());
			listmap.add(map);
		}
		return listmap;
	}

	@Override
	public List<SingleQuestion> getSingleQuestionsByPaperPrimaryKey(Integer paperid) {
		if(paperMapper.selectByPrimaryKey(paperid).getSingleids()==null){
			return null;
		}
		String[] singleids = paperMapper.selectByPrimaryKey(paperid).getSingleids().split(",");
		List<SingleQuestion> resList=new ArrayList<>();
		for(String sid :singleids){
			Integer id=Integer.parseInt(sid);
			SingleQuestion question=singleQuestionMapper.selectByPrimaryKey(id);
			resList.add(question);
		}
		return resList;
	}

	@Override
	public List<MultyQuestion> getMultyQuestionsByPaperPrimaryKey(Integer paperid) {
		if(paperMapper.selectByPrimaryKey(paperid).getMultyids()==null){
			return null;
		}
		String[] multyids = paperMapper.selectByPrimaryKey(paperid).getMultyids().split(",");
		List<MultyQuestion> resList=new ArrayList<>();
		for(String sid :multyids){
			Integer id=Integer.parseInt(sid);
			MultyQuestion question=multyQuestionMapper.selectByPrimaryKey(id);
			resList.add(question);
		}
		return resList;
	}

	@Override
	public List<JudgeQuestion> getJudgeQuestionsByPaperPrimaryKey(Integer paperid) {
		if(paperMapper.selectByPrimaryKey(paperid).getJudgeids()==null){
			return null;
		}
		String[] judgeids = paperMapper.selectByPrimaryKey(paperid).getJudgeids().split(",");
		List<JudgeQuestion> resList=new ArrayList<>();
		for(String sid :judgeids){
			Integer id=Integer.parseInt(sid);
			JudgeQuestion question=judgeQuestionMapper.selectByPrimaryKey(id);
			resList.add(question);
		}
		return resList;
	}

	@Override
	public List<FillQuestion> getFillQuestionsByPaperPrimaryKey(Integer paperid) {
		if(paperMapper.selectByPrimaryKey(paperid).getFillids()==null){
			return null;
		}
		String[] fillids = paperMapper.selectByPrimaryKey(paperid).getFillids().split(",");
		List<FillQuestion> resList=new ArrayList<>();
		for(String sid :fillids){
			Integer id=Integer.parseInt(sid);
			FillQuestion question=fillQuestionMapper.selectByPrimaryKey(id);
			resList.add(question);
		}
		return resList;
	}

	@Override
	public List<SubjectQuestion> getSubjectQuestionsByPaperPrimaryKey(Integer paperid) {
		if(paperMapper.selectByPrimaryKey(paperid).getSubjectids()==null){
			return null;
		}
		String[] subjectids = paperMapper.selectByPrimaryKey(paperid).getSubjectids().split(",");
		List<SubjectQuestion> resList=new ArrayList<>();
		for(String sid :subjectids){
			Integer id=Integer.parseInt(sid);
			SubjectQuestion question=subjectQuestionMapper.selectByPrimaryKey(id);
			resList.add(question);
		}
		return resList;
	}
	

}
