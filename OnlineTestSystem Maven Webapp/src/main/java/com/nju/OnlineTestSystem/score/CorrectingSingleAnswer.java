package com.nju.OnlineTestSystem.score;

import java.util.Iterator;
import java.util.List;

import com.nju.OnlineTestSystem.model.SingleQuestion;

/*
 * author: Liu Kangxin
 * */
public class CorrectingSingleAnswer implements CorrectingAnswer{

	@Override
	public double correct(List answers, List standardAnswers) {
		Iterator<String> answersItr = answers.iterator();
		Iterator<SingleQuestion> standardAnswersItr = standardAnswers.iterator();
		double singleScore = 0;
		while(answersItr.hasNext()){
			String answer = answersItr.next();
			SingleQuestion question = standardAnswersItr.next();
			String standardAnswer = question.getAnswer();
			if(answer.trim().compareTo(standardAnswer.trim()) == 0) singleScore += question.getScore();
		}
		return singleScore;
	}
}
