package com.nju.OnlineTestSystem.service;

public interface TeacherAccountService {
	public boolean login(String loginid,String password);
	public String getNameByLoginId(String loginid);
	public Integer getPrimaryKeyByLoginId(String username);
}
