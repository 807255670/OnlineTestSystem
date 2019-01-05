package com.nju.OnlineTestSystem.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.mapper.FillQuestionMapper;
import com.nju.OnlineTestSystem.mapper.JudgeQuestionMapper;
import com.nju.OnlineTestSystem.mapper.MultyQuestionMapper;
import com.nju.OnlineTestSystem.mapper.SingleQuestionMapper;
import com.nju.OnlineTestSystem.mapper.SubjectQuestionMapper;
import com.nju.OnlineTestSystem.model.FillQuestion;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;
import com.nju.OnlineTestSystem.service.QuestionService;


@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService{
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
	public List<SingleQuestion> getSingleQuestionsByClassPrimaryKey(Integer classid) {	
		List<SingleQuestion> singleList=singleQuestionMapper.selectByClassPrimaryKey(classid);
		return singleList;	
	}

	@Override
	public List<MultyQuestion> getMultyQuestionsByClassPrimaryKey(Integer classid) {
		List<MultyQuestion> multyList=multyQuestionMapper.selectByClassPrimaryKey(classid);
		return multyList;
	}

	@Override
	public List<JudgeQuestion> getJudgeQuestionsByClassPrimaryKey(Integer classid) {
		List<JudgeQuestion> judgeList=judgeQuestionMapper.selectByClassPrimaryKey(classid);
		return judgeList;
	}

	@Override
	public List<FillQuestion> getFillQuestionsByClassPrimaryKey(Integer classid) {
		List<FillQuestion> fillList=fillQuestionMapper.selectByClassPrimaryKey(classid);
		return fillList;
	}

	@Override
	public List<SubjectQuestion> getSubjectQuestionsByClassPrimaryKey(Integer classid) {
		List<SubjectQuestion> subjectList=subjectQuestionMapper.selectByClassPrimaryKey(classid);
		return subjectList;
	}

}
