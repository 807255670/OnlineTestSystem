package com.nju.OnlineTestSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.dto.ClassTag;
import com.nju.OnlineTestSystem.mapper.ClassMapper;
import com.nju.OnlineTestSystem.model.Class;
import com.nju.OnlineTestSystem.service.ClassService;


@Service("ClassService")
public class ClassServiceImpl implements ClassService{
	
	@Resource
	ClassMapper classMapper;
	@Override
	public List<Class> getAllClassByTeacherPrimaryKey(Integer id) {
		List<Class> classList=classMapper.selectByTeacherPrimaryKey(id);
		return classList;
	}
	@Override
	public String getClassNameByPrimaryKey(Integer id) {

		Class c=classMapper.selectByPrimaryKey(id);
		return c.getName();
	}
	@Override
	public Integer getPrimaryKeyByClassName(String classname) {
		Integer classid=classMapper.selectByClassName(classname).getId();
		return classid;
	}

	public List<ClassTag> findAllClassByStudentPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		try{
			return classMapper.findAllClassByStudentPrimaryKey(id);
		}catch(Exception exception){
			exception.printStackTrace();
			return new ArrayList<>();
		}
	}

}
