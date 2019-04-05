package com.nju.OnlineTestSystem.util;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nju.OnlineTestSystem.model.SingleQuestion;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class QuestionInput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -217459483071936958L;
	
	private List<SingleQuestion> questionList;

	public List<SingleQuestion> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<SingleQuestion> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "QuestionInput [questionList=" + questionList + "]";
	}

	
	
	
}