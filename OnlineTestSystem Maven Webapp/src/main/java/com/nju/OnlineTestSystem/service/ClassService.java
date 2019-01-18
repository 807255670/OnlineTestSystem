package com.nju.OnlineTestSystem.service;

import java.util.List;

import com.nju.OnlineTestSystem.dto.ClassTag;
import com.nju.OnlineTestSystem.model.Class;;

public interface ClassService {
	public List<Class> getAllClassByTeacherPrimaryKey(Integer id);
	public String getClassNameByPrimaryKey(Integer id);
	
	/*
	 * author: Liu Kangxin
	 * */
	public List<ClassTag> findAllClassByStudentPrimaryKey(Integer id);
}
