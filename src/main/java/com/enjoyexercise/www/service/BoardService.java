package com.enjoyexercise.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.UserVO;

public interface BoardService {
	//Method
	List<BoardVO> getNoticeList(BoardVO vo);
	
	List<BoardVO> getInfoList(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	int getBoardCnt(BoardVO vo);
	
	void updateBoardCnt(BoardVO vo);
	
	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);
	
	void updateBoardFile(BoardVO vo);

	void deleteBoard(BoardVO vo);

}
