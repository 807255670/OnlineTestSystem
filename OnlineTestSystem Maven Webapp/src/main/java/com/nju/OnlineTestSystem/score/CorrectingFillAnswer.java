package com.nju.OnlineTestSystem.score;

import java.util.Iterator;
import java.util.List;

import com.nju.OnlineTestSystem.dto.FillQuestionDto;

/*
 * author: Liu Kangxin
 * */
public class CorrectingFillAnswer implements CorrectingAnswer{
	private boolean judge(String a1,String a2){
		a1 = a1.replace(" ", "");
		a2 = a2.replace(" ", "");
		if(a1.compareTo(a2) == 0)return true;
		return false;
	}
	
	@Override
	public double correct(List answers, List standardAnswers) {
		Iterator<List> answersItr = answers.iterator();
		Iterator<FillQuestionDto> standardAnswersItr = standardAnswers.iterator();
		double fillScore = 0;
		while(answersItr.hasNext()){
			List answer = answersItr.next();
			FillQuestionDto question = standardAnswersItr.next();
			int count = 0;
			try{
				String a1 = "a";
				String a2 = "";
				a1 = (String)answer.get(0);
				a2 = question.getAnswer1();
				if(a2 != null && judge(a1, a2)) count++;
				a1 = (String)answer.get(1);
				a2 = question.getAnswer2();
				if(a2 != null && judge(a1, a2)) count++;
				a1 = (String)answer.get(2);
				a2 = question.getAnswer3();
				if(a2 != null && judge(a1, a2)) count++;
				a1 = (String)answer.get(3);
				a2 = question.getAnswer4();
				if(a2 != null && judge(a1, a2)) count++;
				a1 = (String)answer.get(4);
				a2 = question.getAnswer5();
				if(a2 != null && judge(a1, a2)) count++;
				a1 = (String)answer.get(5);
				a2 = question.getAnswer6();
				if(a2 != null && judge(a1, a2)) count++;
			}catch(Exception exception){
			}
			fillScore += ((count * 1.0) / question.getSpaceCount()) * question.getScore();
		}
		return fillScore;
	}
}
