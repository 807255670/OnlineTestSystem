package com.nju.OnlineTestSystem.model;

import java.util.Date;

public class Paper {
    private Integer id;

    private String name;

    private Integer classid;

    private Date deadtime;

    private String password;

    private String singleids;

    private String multyids;

    private String judgeids;

    private String fillids;

    private String subjectids;

    private Boolean visible;

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
        this.name = name == null ? null : name.trim();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSingleids() {
        return singleids;
    }

    public void setSingleids(String singleids) {
        this.singleids = singleids == null ? null : singleids.trim();
    }

    public String getMultyids() {
        return multyids;
    }

    public void setMultyids(String multyids) {
        this.multyids = multyids == null ? null : multyids.trim();
    }

    public String getJudgeids() {
        return judgeids;
    }

    public void setJudgeids(String judgeids) {
        this.judgeids = judgeids == null ? null : judgeids.trim();
    }

    public String getFillids() {
        return fillids;
    }

    public void setFillids(String fillids) {
        this.fillids = fillids == null ? null : fillids.trim();
    }

    public String getSubjectids() {
        return subjectids;
    }

    public void setSubjectids(String subjectids) {
        this.subjectids = subjectids == null ? null : subjectids.trim();
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}