package com.nju.OnlineTestSystem.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.mapper.PaperMapper;
import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.service.PaperService;

@Service("PaperService")
public class PaperServiceImpl implements PaperService{
	
	@Resource
	PaperMapper paperMapper;
	
	@Override
	public List<Paper> getAllPapersByClassPrimaryKey(Integer classid) {
		// TODO Auto-generated method stub
		List<Paper> paperList=paperMapper.selectByClassPrimaryKey(classid);
		return paperList;
	}
	

}
