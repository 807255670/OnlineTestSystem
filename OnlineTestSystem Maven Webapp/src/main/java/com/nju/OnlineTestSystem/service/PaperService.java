package com.nju.OnlineTestSystem.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.nju.OnlineTestSystem.dto.FillQuestionDto;
import com.nju.OnlineTestSystem.dto.PaperScoreDto;
import com.nju.OnlineTestSystem.dto.PaperSummary;
import com.nju.OnlineTestSystem.model.FillQuestion;
import com.nju.OnlineTestSystem.model.JudgeQuestion;
import com.nju.OnlineTestSystem.model.MultyQuestion;
import com.nju.OnlineTestSystem.model.Paper;
import com.nju.OnlineTestSystem.model.SingleQuestion;
import com.nju.OnlineTestSystem.model.SubjectQuestion;

public interface PaperService {
	 public List<Paper> getAllPapersByClassPrimaryKey(Integer classid);
	 
	 public List<HashMap> getStudentScoreByPaperPrimaryKey(Integer paperid);
	 
	 public String getPaperNameByPrimaryKey(Integer id);
	 
	 public List<HashMap> getAllPapersByTeacherPrimaryKey(Integer teacherid);
	 
	 public List<SingleQuestion> getSingleQuestionsByPaperPrimaryKey(Integer paperid);
	 public List<MultyQuestion> getMultyQuestionsByPaperPrimaryKey(Integer paperid);
	 public List<JudgeQuestion> getJudgeQuestionsByPaperPrimaryKey(Integer paperid);
	 public List<FillQuestion> getFillQuestionsByPaperPrimaryKey(Integer paperid);
	 public List<SubjectQuestion> getSubjectQuestionsByPaperPrimaryKey(Integer paperid);
	 

	 public String getSingleidsByPaperPrimaryKey(Integer paperid);
	 public String getMultyidsByPaperPrimaryKey(Integer paperid);
	 public String getFillidsByPaperPrimaryKey(Integer paperid);
	 public String getJudgeidsByPaperPrimaryKey(Integer paperid);
	 public String getSubjectidsByPaperPrimaryKey(Integer paperid);

	public boolean canBeAdded(Integer questionid,String questiontype,Integer paperid);

	public void updateQuestion(Integer paperid, String questiontype, String questionids);

	public boolean generatePaper(String papername, String password, Date deadtime, Integer classid, Integer single,
			Integer multiple, Integer judge, Integer fill, Integer subject);



	 

	 /*
	  * author: Liu Kangxin
	  * */
	 public List<PaperSummary> findPapersByClassidAndStudentPK(Integer studentPrimaryKey,Integer classid);
	 public List<FillQuestionDto> getFillQuestionsDtoByPaperPrimaryKey(Integer paperid);
	 public int updateScoreByPaperScore(PaperScoreDto paperScore);
	 public int insertScoreByPaperScore(PaperScoreDto paperScore);
	 public Paper selectByPrimaryKey(Integer id);

}
