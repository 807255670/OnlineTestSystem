package com.nju.OnlineTestSystem.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.OnlineTestSystem.mapper.ClassMapper;
import com.nju.OnlineTestSystem.mapper.PaperMapper;
import com.nju.OnlineTestSystem.mapper.StudentMapper;
import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.service.PaperService;

@Service("PaperService")
public class PaperServiceImpl implements PaperService{
	
	@Resource
	PaperMapper paperMapper;
	@Resource
	StudentMapper studentMapper;
	@Resource
	ClassMapper classMapper;
	
	@Override
	public List<Paper> getAllPapersByClassPrimaryKey(Integer classid) {
		// TODO Auto-generated method stub
		List<Paper> paperList=paperMapper.selectByClassPrimaryKey(classid);
		return paperList;
	}

	@Override
	public List<HashMap> getStudentScoreByPaperPrimaryKey(Integer paperid) {
		
		List<HashMap> students=studentMapper.selectStudentScoreByPaperPrimaryKey(paperid);
		for (HashMap eachmap:students){
			Integer score1=(Integer) eachmap.get("singlescore");
			Integer score2=(Integer) eachmap.get("multyscore");
			Integer score3=(Integer) eachmap.get("judgescore");
			Integer score4=(Integer) eachmap.get("fillscore");
			Integer score5=(Integer) eachmap.get("subjectscore");
			if(score1==null){
				score1=0;
			}
			if(score2==null){
				score2=0;
			}
			if(score3==null){
				score3=0;
			}
			if(score4==null){
				score4=0;
			}
			if(score5==null){
				score5=0;
			}
			eachmap.put("score", score1+score2+score3+score4+score5);
		}
		return students;
	}

	@Override
	public String getPaperNameByPrimaryKey(Integer id) {
		Paper p=paperMapper.selectByPrimaryKey(id);
		return p.getName();
	}

	@Override
	public List<HashMap> getAllPapersByTeacherPrimaryKey(Integer teacherid) {
		List<HashMap> listmap = new ArrayList<>();
		List<Paper> list=paperMapper.selectByTeacherPrimaryKey(teacherid);
		for(Paper paper:list){
			HashMap<String, Object> map=new HashMap<>();
			Integer classid=paper.getClassid();
			String classname=classMapper.selectByPrimaryKey(classid).getName();
			map.put("paperid", paper.getId());
			map.put("classname",classname);
			map.put("papername",paper.getName());
			listmap.add(map);
		}
		return listmap;
	}
	

}
