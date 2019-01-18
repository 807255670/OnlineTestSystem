package com.nju.OnlineTestSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nju.OnlineTestSystem.dto.PaperSummary;
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
    
    /*
     * func: 获取“我”的试卷
     * author: Liu Kangxin
     * */
    List<PaperSummary> findPapersByClassidAndStudentPK(@Param(value="studentPrimaryKey") Integer studentPrimaryKey,@Param(value="classid")Integer classid);
}