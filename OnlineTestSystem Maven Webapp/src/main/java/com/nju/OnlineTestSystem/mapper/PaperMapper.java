package com.nju.OnlineTestSystem.mapper;

import java.util.List;

import com.nju.OnlineTestSystem.model.Paper;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);
    
    List<Paper> selectByClassPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
        
    List<Paper> selectByTeacherPrimaryKey(Integer teacherid);
    
}