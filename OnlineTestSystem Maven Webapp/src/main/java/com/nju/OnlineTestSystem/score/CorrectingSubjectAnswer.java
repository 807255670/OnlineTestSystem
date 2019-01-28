package com.nju.OnlineTestSystem.score;

import java.util.Iterator;
import java.util.List;

import com.nju.OnlineTestSystem.model.SubjectQuestion;

/*
 * author: Liu Kangxin
 * */
public class CorrectingSubjectAnswer implements CorrectingAnswer{

	private static int KEY_COUNT = 4;
	private int judge(String answer,String[] keys){
		int count = 0;
		for(int i = 0;i < KEY_COUNT;i++){
			if(keys[i] != null && answer.contains(keys[i].replace(" ", ""))) count++;
		}
		return count;
	}
	
	@Override
	public double correct(List answers, List standardAnswers) {
		Iterator<String> answersItr = answers.iterator();
		Iterator<SubjectQuestion> standardAnswersItr = standardAnswers.iterator();
		double subjectScore = 0;
		while(answersItr.hasNext()){
			int count = 0;
			String answer = answersItr.next();
			SubjectQuestion question = standardAnswersItr.next();
			String[] keys = new String[KEY_COUNT];
			if(question.getKey1() != null){
				keys[0] = question.getKey1();
				count++;
			}
			if(question.getKey2() != null){
				keys[1] = question.getKey2();
				count++;
			}
			if(question.getKey3() != null){
				keys[2] = question.getKey3();
				count++;
			}
			if(question.getKey4() != null){
				keys[3] = question.getKey4();
				count++;
			}
			subjectScore += ((judge(answer, keys) * 1.0 / count) * question.getScore());
		}
		return subjectScore;
	}

}
