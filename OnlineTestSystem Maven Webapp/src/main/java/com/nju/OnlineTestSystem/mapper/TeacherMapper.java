package com.nju.OnlineTestSystem.mapper;

import com.nju.OnlineTestSystem.model.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);
    
    //根据登录账号查找
    Teacher selectByLoginId(String loginid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}