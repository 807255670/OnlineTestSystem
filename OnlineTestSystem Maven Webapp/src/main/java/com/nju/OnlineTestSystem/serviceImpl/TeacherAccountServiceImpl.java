package com.nju.OnlineTestSystem.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.mapper.TeacherMapper;
import com.nju.OnlineTestSystem.model.Teacher;
import com.nju.OnlineTestSystem.service.TeacherAccountService;

@Service("TeacherAccountService")
public class TeacherAccountServiceImpl implements TeacherAccountService {
	
	@Resource
	TeacherMapper teacherMapper;
	
	
	@Override
	public boolean login(String loginid, String password) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherMapper.selectByLoginId(loginid);
		if(teacher!=null){
			if(teacher.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}


	@Override
	public String getNameByLoginId(String loginid) {
		
		Teacher teacher=teacherMapper.selectByLoginId(loginid);
		if(teacher!=null){	
			String teacherName = teacher.getName();
			if(teacherName!=null){
				return teacherName;
			}
			return "姓名丢失";
		}
		return "用户不存在";
	}


	@Override
	public Integer getPrimaryKeyByLoginId(String loginid) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherMapper.selectByLoginId(loginid);
		if(teacher!=null){	
			Integer teacherPrimary = teacher.getId();
			if(teacherPrimary!=null){
				return teacherPrimary;
			}
			return 0;
		}
		return 0;
	}
	

}
