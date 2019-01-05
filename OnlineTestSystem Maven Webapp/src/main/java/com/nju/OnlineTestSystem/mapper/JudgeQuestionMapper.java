package com.nju.OnlineTestSystem.mapper;

import java.util.List;

import com.nju.OnlineTestSystem.model.JudgeQuestion;

public interface JudgeQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JudgeQuestion record);

    int insertSelective(JudgeQuestion record);

    JudgeQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JudgeQuestion record);

    int updateByPrimaryKey(JudgeQuestion record);
    List<JudgeQuestion> selectByClassPrimaryKey(Integer classid);
}