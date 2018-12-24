package com.nju.OnlineTestSystem.mapper;

import com.nju.OnlineTestSystem.model.MultyQuestion;

public interface MultyQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MultyQuestion record);

    int insertSelective(MultyQuestion record);

    MultyQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MultyQuestion record);

    int updateByPrimaryKey(MultyQuestion record);
}