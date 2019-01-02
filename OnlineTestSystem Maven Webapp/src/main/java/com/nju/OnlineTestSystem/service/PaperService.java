package com.nju.OnlineTestSystem.service;

import java.util.HashMap;
import java.util.List;

import com.nju.OnlineTestSystem.model.Paper;

public interface PaperService {
	 public List<Paper> getAllPapersByClassPrimaryKey(Integer classid);
	 
	 public List<HashMap> getStudentScoreByPaperPrimaryKey(Integer paperid);
	 
	 public String getPaperNameByPrimaryKey(Integer id);
	 
	 public List<HashMap> getAllPapersByTeacherPrimaryKey(Integer teacherid);
}
