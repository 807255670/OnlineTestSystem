package com.nju.OnlineTestSystem.mapper;

import com.nju.OnlineTestSystem.dto.PaperScoreDto;

/*
 * author: Liu Kangxin
 * */
public interface PaperScoreMapper {
	int updateScoreByPaperScore(PaperScoreDto paperScore);
	int insertScoreByPaperScore(PaperScoreDto paperScore);
}
