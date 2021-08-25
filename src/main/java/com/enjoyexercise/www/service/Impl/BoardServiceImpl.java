package com.enjoyexercise.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoyexercise.www.dao.BoardDAO;
import com.enjoyexercise.www.service.BoardService;
import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.UserVO;



@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getNoticeList(BoardVO vo) {
		return boardDAO.getNoticeList(vo);
	}

	@Override
	public List<BoardVO> getInfoList(BoardVO vo) {
		return boardDAO.getInfoList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public int getBoardCnt(BoardVO vo) {
		return boardDAO.getBoardCnt(vo);
	}

	@Override
	public void updateBoardCnt(BoardVO vo) {
		boardDAO.updateBoardCnt(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@Override
	public void updateBoardFile(BoardVO vo) {
		boardDAO.updateBoardFile(vo);
	}
	
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	

}
