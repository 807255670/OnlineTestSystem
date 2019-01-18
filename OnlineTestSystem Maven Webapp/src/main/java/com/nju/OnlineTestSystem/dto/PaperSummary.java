package com.nju.OnlineTestSystem.dto;

import java.util.Date;

/*
 * func: 映射学生的试卷作答概况
 * author: Liu Kangxin
 * */
public class PaperSummary {
    private Integer id;
    private String name;
    private Integer classid;
    private Date deadtime;
    private Date anserDate;
    private Integer singleScore;
    private Integer multyScore;
    private Integer judgeScore;
    private Integer fillScore;
    private Integer subjectScore;
    private int totalScore;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public Date getDeadtime() {
		return deadtime;
	}
	public void setDeadtime(Date deadtime) {
		this.deadtime = deadtime;
	}
	public Date getAnserDate() {
		return anserDate;
	}
	public void setAnserDate(Date anserDate) {
		this.anserDate = anserDate;
	}
	public Integer getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(Integer singleScore) {
		this.singleScore = singleScore;
	}
	public Integer getMultyScore() {
		return multyScore;
	}
	public void setMultyScore(Integer multyScore) {
		this.multyScore = multyScore;
	}
	public Integer getJudgeScore() {
		return judgeScore;
	}
	public void setJudgeScore(Integer judgeScore) {
		this.judgeScore = judgeScore;
	}
	public Integer getFillScore() {
		return fillScore;
	}
	public void setFillScore(Integer fillScore) {
		this.fillScore = fillScore;
	}
	public Integer getSubjectScore() {
		return subjectScore;
	}
	public void setSubjectScore(Integer subjectScore) {
		this.subjectScore = subjectScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
    
    
}
