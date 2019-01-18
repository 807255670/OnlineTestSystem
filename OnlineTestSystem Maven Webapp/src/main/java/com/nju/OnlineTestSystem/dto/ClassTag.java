package com.nju.OnlineTestSystem.dto;

/*
 * func: 映射学生的课程列表
 * author: Liu Kangxin
 * */
public class ClassTag {
	private Integer id;
	private String className;
	private String teacherName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
