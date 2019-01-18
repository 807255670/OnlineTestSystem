package com.nju.OnlineTestSystem.mapper;

import java.util.List;

import com.nju.OnlineTestSystem.dto.ClassTag;
import com.nju.OnlineTestSystem.model.Class;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);
    List<Class> selectByTeacherPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
    
    /*
     * author: Liu Kangxin
     * */
    List<ClassTag> findAllClassByStudentPrimaryKey(Integer id);
}