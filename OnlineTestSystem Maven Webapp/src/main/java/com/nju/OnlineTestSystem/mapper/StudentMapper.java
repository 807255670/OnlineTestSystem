package com.nju.OnlineTestSystem.mapper;

import java.util.HashMap;
import java.util.List;

import com.nju.OnlineTestSystem.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<HashMap> selectStudentScoreByPaperPrimaryKey(Integer paperid);
    
    /*
     * function:学生登录
     * author: Liu Kangxin
     * */
    Student selectByLoginId(String loginid);
}