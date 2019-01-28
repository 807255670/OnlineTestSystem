package com.nju.OnlineTestSystem.score;

import java.util.Iterator;
import java.util.List;

import com.nju.OnlineTestSystem.model.MultyQuestion;

/*
 * author: Liu Kangxin
 * */
public class CorrectingMultyAnswer implements CorrectingAnswer{

	@Override
	public double correct(List answers, List standardAnswers) {
		if(answers==null||standardAnswers==null){
			return 0;
		}
		Iterator<String> answersItr = answers.iterator();
		Iterator<MultyQuestion> standardAnswersItr = standardAnswers.iterator();
		double multyScore = 0;
		while(answersItr.hasNext()){
			String answer = answersItr.next();
			MultyQuestion question = standardAnswersItr.next();
			String standardAnswer = question.getAnswer();
			if(answer.trim().compareTo(standardAnswer.trim()) == 0) multyScore += question.getScore();
		}
		return multyScore;
	}

}
