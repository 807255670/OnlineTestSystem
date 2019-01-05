package com.nju.OnlineTestSystem.service;

import java.util.HashMap;
import java.util.List;

import com.nju.OnlineTestSystem.model.FillQuestion;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;

public interface QuestionService {
	public List<SingleQuestion> getSingleQuestionsByClassPrimaryKey(Integer classid);
	public List<MultyQuestion> getMultyQuestionsByClassPrimaryKey(Integer classid);
	public List<JudgeQuestion> getJudgeQuestionsByClassPrimaryKey(Integer classid);
	public List<FillQuestion> getFillQuestionsByClassPrimaryKey(Integer classid);
	public List<SubjectQuestion> getSubjectQuestionsByClassPrimaryKey(Integer classid);
}
