package com.nju.OnlineTestSystem.model;

public class SingleQuestion {
    private Integer id;

    private Integer classid;

    private String body;

    private String optiona;

    private String oprionb;

    private String oprionc;

    private String opriond;

    private String oprione;

    private String oprionf;

    private String answer;

    private Integer score;

    private Boolean visible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona == null ? null : optiona.trim();
    }

    public String getOprionb() {
        return oprionb;
    }

    public void setOprionb(String oprionb) {
        this.oprionb = oprionb == null ? null : oprionb.trim();
    }

    public String getOprionc() {
        return oprionc;
    }

    public void setOprionc(String oprionc) {
        this.oprionc = oprionc == null ? null : oprionc.trim();
    }

    public String getOpriond() {
        return opriond;
    }

    public void setOpriond(String opriond) {
        this.opriond = opriond == null ? null : opriond.trim();
    }

    public String getOprione() {
        return oprione;
    }

    public void setOprione(String oprione) {
        this.oprione = oprione == null ? null : oprione.trim();
    }

    public String getOprionf() {
        return oprionf;
    }

    public void setOprionf(String oprionf) {
        this.oprionf = oprionf == null ? null : oprionf.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}