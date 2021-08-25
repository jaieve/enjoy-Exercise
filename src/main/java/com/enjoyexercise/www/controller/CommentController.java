package com.enjoyexercise.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.enjoyexercise.www.service.BoardService;
import com.enjoyexercise.www.service.CommentService;
import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.CommentVO;

@Controller
@SessionAttributes("board")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private BoardService boardService;
	
//	@RequestMapping(value="/getCommentList.do")
//	public String getCommentList(BoardVO vo, Model model){
//		System.out.println("CommentController-getCommentList()");
//		model.addAttribute("commentList",commentService.getCommentList(vo));
//		String category = vo.getCategory();
//		String goal = null;
//		if(category.equals("NOTICE")) {
//			goal = "getNoticeList.do";
//		} else {
//			goal = "getInfoList.do";
//		}
//		return goal;
//	}
	
	//insertComment
	@RequestMapping(value="/insertComment.do")
	public String insertComment(CommentVO comment, Model model) {
		System.out.println("CommentController-insertComment()");
		String category = comment.getCategory();
		
		commentService.insertComment(comment);
		//다시 board값 가져와서 보내주기.
		BoardVO board = new BoardVO();
		
		//test
		System.out.println("댓글달린 게시글 번호(seq)"+comment.getBoard_id());
		board.setSeq(comment.getBoard_id());
		board.setCategory(category);
		//test
		
		
		board = boardService.getBoard(board);
		board.setCategory(category);
		//test
		//System.out.println(board.toString());
		
		model.addAttribute("board", board);
		
		return "getBoard.do";
	}
	
	//deleteComment
	@RequestMapping(value="/deleteComment.do")
	public String deleteComment(CommentVO comment, Model model) {
		System.out.println("CommentController-deleteComment()");
		//보낼때 필요한 값. board_id, category -> vo.setSeq();, vo.setCategory();
		//BoardVO vo 에 담아서 보내야 함.
		String category = comment.getCategory();
		
		commentService.deleteComment(comment);
		
		BoardVO board = new BoardVO();
		
		//board_id
		//System.out.println("댓글달린 게시글 번호(seq)"+comment.getBoard_id());
		//test
		System.out.println("'댓글삭제'에서 받은 값 : "+comment.getBoard_id());
		System.out.println("'댓글삭제'에서 받은 값 : "+category);
		
		board.setSeq(comment.getBoard_id());
		board.setCategory(category);
		//category
		board = boardService.getBoard(board);
		board.setCategory(category);
		
		model.addAttribute("board",board);
		return "getBoard.do"; 
	}
	
	//updateComment
	@RequestMapping(value="/updateComment.do")
	public String updateComment(CommentVO comment, Model model) {
		System.out.println("CommentController-deleteComment()");
		//test
		System.out.println(comment.toString());
		
		//getBoard.do에 갔을 때 필요한 값 : seq(board_id), category
		String category = comment.getCategory();
		int board_id = comment.getBoard_id();
		BoardVO board = new BoardVO();
		board.setCategory(category);
		board.setSeq(board_id);
		model.addAttribute("board", board);
		
		//commentService에 보내야하는 값. reply, reply_id
		commentService.updateComment(comment);
		return "getBoard.do"; 
	}
	
	
}
