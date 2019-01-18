package com.nju.OnlineTestSystem.service;

public interface StudentAccountService {
	public boolean login(String loginid,String password);
	public String getNameByLoginId(String loginid);
	public Integer getPrimaryKeyByLoginId(String username);
}
