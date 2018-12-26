package com.nju.OnlineTestSystem.service;

import java.util.List;

import com.nju.OnlineTestSystem.model.Paper;

public interface PaperService {
	 public List<Paper> getAllPapersByClassPrimaryKey(Integer classid);
}
