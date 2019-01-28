package com.nju.OnlineTestSystem.score;

import java.util.Iterator;
import java.util.List;

import com.nju.OnlineTestSystem.model.JudgeQuestion;

/*
 * author: Liu Kangxin
 * */
public class CorrectingJudgeAnswer implements CorrectingAnswer{
	private int parse(String answer){
		answer = answer.trim();
		if(answer.compareTo("A") == 0 || answer.compareTo("T") == 0) return 1;
		else return 0;
	}
	
	@Override
	public double correct(List answers, List standardAnswers) {
		Iterator<String> answersItr = answers.iterator();
		Iterator<JudgeQuestion> standardAnswersItr = standardAnswers.iterator();
		double judgeScore = 0;
		while(answersItr.hasNext()){
			String answer = answersItr.next();
			JudgeQuestion question = standardAnswersItr.next();
			String standardAnswer = question.getAnswer();
			if(parse(answer) == parse(standardAnswer)) judgeScore += question.getScore();
		}
		return judgeScore;
	}
}
