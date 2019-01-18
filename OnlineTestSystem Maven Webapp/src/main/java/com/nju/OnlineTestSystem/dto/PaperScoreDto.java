package com.nju.OnlineTestSystem.dto;

import java.util.Date;

public class PaperScoreDto {
	private Integer id;
	private Integer studentPrimaryKey;
	private Integer paperid;
	private Date anserdate;
	private Integer singleScore;
	private Integer multyScore;
	private Integer judgeScore;
	private Integer fillScore;
	private Integer subjectScore;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentPrimaryKey() {
		return studentPrimaryKey;
	}
	public void setStudentPrimaryKey(Integer studentPrimaryKey) {
		this.studentPrimaryKey = studentPrimaryKey;
	}
	public Integer getPaperid() {
		return paperid;
	}
	public void setPaperid(Integer paperid) {
		this.paperid = paperid;
	}
	public Date getAnserdate() {
		return anserdate;
	}
	public void setAnserdate(Date anserdate) {
		this.anserdate = anserdate;
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
	
	
}
