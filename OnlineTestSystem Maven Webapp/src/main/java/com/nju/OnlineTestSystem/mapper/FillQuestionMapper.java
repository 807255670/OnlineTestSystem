package com.nju.OnlineTestSystem.mapper;

import com.nju.OnlineTestSystem.model.FillQuestion;

public interface FillQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FillQuestion record);

    int insertSelective(FillQuestion record);

    FillQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FillQuestion record);

    int updateByPrimaryKey(FillQuestion record);
}