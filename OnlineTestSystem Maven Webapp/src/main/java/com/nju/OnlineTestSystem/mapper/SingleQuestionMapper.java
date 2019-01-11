package com.nju.OnlineTestSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nju.OnlineTestSystem.model.SingleQuestion;

public interface SingleQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SingleQuestion record);

    int insertSelective(SingleQuestion record);

    SingleQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SingleQuestion record);

    int updateByPrimaryKey(SingleQuestion record);
    
    List<SingleQuestion> selectByClassPrimaryKey(Integer classid);
    List<SingleQuestion> selectLastQuestionsByClassPrimaryKey(Integer number,Integer classid);
}