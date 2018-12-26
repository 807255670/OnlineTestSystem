package com.nju.OnlineTestSystem.service;

import java.util.List;
import com.nju.OnlineTestSystem.model.Class;;

public interface ClassService {
	public List<Class> getAllClassByTeacherPrimaryKey(Integer id);
	
}
