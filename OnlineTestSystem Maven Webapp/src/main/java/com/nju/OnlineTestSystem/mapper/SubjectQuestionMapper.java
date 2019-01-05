package com.nju.OnlineTestSystem.mapper;

import java.util.List;

import com.nju.OnlineTestSystem.model.SubjectQuestion;

public interface SubjectQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectQuestion record);

    int insertSelective(SubjectQuestion record);

    SubjectQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectQuestion record);

    int updateByPrimaryKey(SubjectQuestion record);
    List<SubjectQuestion> selectByClassPrimaryKey(Integer classid);
}