package com.nju.OnlineTestSystem.score;

import java.util.List;

/*
 * func: 根据不同题型，比对学生答案和标准答案，并计算得分
 * author: Liu Kangxin
 * */
public interface CorrectingAnswer {
	public double correct(List answers,List standardAnswers);
}
