package com.nju.OnlineTestSystem.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.mapper.StudentMapper;
import com.nju.OnlineTestSystem.model.Student;
import com.nju.OnlineTestSystem.service.StudentAccountService;

@Service
public class StudentAccountServiceImpl implements StudentAccountService{
	@Resource
	StudentMapper studentMapper;
	
	
	@Override
	public boolean login(String loginid, String password) {
		// TODO Auto-generated method stub
		Student student=studentMapper.selectByLoginId(loginid);
		if(student!=null){
			if(student.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}


	@Override
	public String getNameByLoginId(String loginid) {
		
		Student student=studentMapper.selectByLoginId(loginid);
		if(student!=null){	
			String studentName = student.getName();
			if(studentName!=null){
				return studentName;
			}
			return "姓名丢失";
		}
		return "用户不存在";
	}


	@Override
	public Integer getPrimaryKeyByLoginId(String loginid) {
		// TODO Auto-generated method stub
		Student student=studentMapper.selectByLoginId(loginid);
		if(student!=null){	
			Integer studentPrimary = student.getId();
			if(studentPrimary!=null){
				return studentPrimary;
			}
			return 0;
		}
		return 0;
	}
}
