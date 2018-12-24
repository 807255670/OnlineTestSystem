package com.nju.OnlineTestSystem.mapper;

import com.nju.OnlineTestSystem.model.SingleQuestion;

public interface SingleQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SingleQuestion record);

    int insertSelective(SingleQuestion record);

    SingleQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SingleQuestion record);

    int updateByPrimaryKey(SingleQuestion record);
}