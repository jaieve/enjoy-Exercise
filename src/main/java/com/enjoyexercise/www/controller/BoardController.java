package com.enjoyexercise.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.enjoyexercise.www.service.BoardService;
import com.enjoyexercise.www.service.CommentService;
import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.CommentVO;
import com.enjoyexercise.www.vo.PagingVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentService commentService;

	@ModelAttribute("searchType")
	public Map<String, String> searchType(){
		Map<String, String> searchType = new HashMap<String, String>();
		searchType.put("Title", "TITLE");
		searchType.put("Content", "CONTENT");

		return searchType;
	}
	
	@RequestMapping(value="/getNoticeList.do")
	public String getNoticeList(BoardVO board, Model model, 
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="1") int range) {
		System.out.println("BoardController-getNoticeList()");

		//검색하지 않을 때 - 검색 조건 초기화
		if(board.getSearchType() == null) board.setSearchType("TITLE");
	    if(board.getSearchKeyword() == null) board.setSearchKeyword("");
		//총 게시물 수 가져오기
	    board.setCategory("NOTICE");
		int listCnt = boardService.getBoardCnt(board);
		System.out.println("curPage =>>>>>" + curPage);
		System.out.println("Ragne(구간) =>>>>>" + range);
		System.out.println("getSearchType =>>>>>" + board.getSearchType());
	    System.out.println("setSearchKeyword =>>>>>" + board.getSearchKeyword());
		
		//Paging해서 각 정보 넘겨주기
		PagingVO paging = new PagingVO();
		paging.pageInfo(curPage, range, listCnt);
		
		board.setStartList(paging.getStartList());
		board.setEndList(paging.getEndList());
		
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardService.getNoticeList(board));
		model.addAttribute("category",board.getCategory());
		
		//search 정보
		model.addAttribute("searchInfo",board);
		return "notice/getNoticeList.jsp"; 
		//return "redirect:~"; 로 보내면 model 값이 안넘어간다.boardList 값을 .jsp에서 못받는다.
	}
	
	@RequestMapping(value="/getNoticeListMain.do", method=RequestMethod.POST)
	@ResponseBody
	public List<BoardVO> getNoticeListMain(BoardVO board, Model model, 
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="1") int range) {
		System.out.println("BoardController-getNoticeListMain()");

		//검색하지 않을 때 - 검색 조건 초기화
		if(board.getSearchType() == null) board.setSearchType("TITLE");
	    if(board.getSearchKeyword() == null) board.setSearchKeyword("");
		//총 게시물 수 가져오기
	    board.setCategory("NOTICE");
	    
		int listCnt = boardService.getBoardCnt(board);
		PagingVO paging = new PagingVO();
		paging.pageInfo(curPage, range, listCnt);
		
		board.setStartList(paging.getStartList());
		board.setEndList(paging.getEndList());
		List<BoardVO> NoticeList = boardService.getNoticeList(board);
		System.out.println(NoticeList.size());
		return NoticeList; 
		//return "redirect:~"; 로 보내면 model 값이 안넘어간다.boardList 값을 .jsp에서 못받는다.
	}
	
//	public String getInfoList() {}
	
	@RequestMapping(value="/getBoard.do", method=RequestMethod.GET)
	public String getBoard(BoardVO board, Model model, HttpServletRequest request ) {
		System.out.println("BoardController-getBoard()");
		//test
		System.out.println("CommentController에서 BoardController로 받은 board값" + board.toString());
		//다른 컨트롤러에서 board 정보 받는 경우
		if(request.getAttribute("board")!=null) {
			board = (BoardVO)request.getAttribute("board");
		}
//		//test
//		System.out.println("댓글작성후 넘겨받은 board"+board.toString());
		//카테고리 저장해두기
		String category = board.getCategory();
		//조회수 증가
		boardService.updateBoardCnt(board);
		board.setCnt(board.getCnt()+1);
		//카테고리 & 글번호
		board = boardService.getBoard(board);
		board.setCategory(category);
		
		model.addAttribute("board", board);
		
		List<CommentVO> commentList = commentService.getCommentList(board);
		List<CommentVO> recommentList = commentService.getRecommentList(board);
		
		model.addAttribute("commentList", commentList);
		model.addAttribute("recommentList", recommentList);
		//System.out.println("category : "+board.getCategory());
		String goal = null;
		if(board.getCategory().equals("NOTICE")) {
			goal =  "notice/getNotice.jsp";
		} else if(board.getCategory().equals("INFO")) {
			goal = "info/getInfo.jsp";
		}
		return goal;
	}
	
	//게시판 글 수정
	@RequestMapping(value="/updateBoard.do", method=RequestMethod.POST)
	public String updateBoard(BoardVO board, Model model) {
		System.out.println("BoardController-updateBoard()");
		//test
		//System.out.println(board.toString());
		MultipartFile uploadFile = board.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String filePath = "E:/bigdata210128_workspace/Spring/EnjoyExercise/src/main/webapp/images/boardimg/";
			String fileName = uploadFile.getOriginalFilename();
			System.out.println(uploadFile.getContentType());
			board.setFilename(fileName);
			try {
				uploadFile.transferTo(new File(filePath+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String category = board.getCategory();
		boardService.updateBoard(board);
		board = boardService.getBoard(board);
		board.setCategory(category);
		model.addAttribute("board",board);
		String goal = null;
		if(category.equals("NOTICE")) {
			goal =  "notice/getNotice.jsp";
		} else if(board.getCategory().equals("INFO")) {
			goal = "info/getInfo.jsp";
		}
		return goal;
	}
	
	//게시판 글 등록
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO board) {
		System.out.println("BoardController-insertBoard()");
		
		MultipartFile uploadFile = board.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String filePath = "E:/bigdata210128_workspace/Spring/EnjoyExercise/src/main/webapp/images/boardimg/";
			String fileName = uploadFile.getOriginalFilename();
			System.out.println(uploadFile.getContentType());
			board.setFilename(fileName);
			try {
				uploadFile.transferTo(new File(filePath+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String category = board.getCategory();
		System.out.println(board.getFilename());
		boardService.insertBoard(board);
		//return "notice/insertNotice.jsp";
		String goal = null;
		if(category.equals("NOTICE")) {
			goal =  "/getNoticeList.do";
		} else if(category.equals("INFO")) {
			goal = "/getInfoList.do";
		}
		return goal;
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO board) {
		System.out.println("BoardController-deleteBoard()");
		String category = board.getCategory();
		System.out.println(board.toString());
		boardService.deleteBoard(board);
		
		String goal = null;
		if(category.equals("NOTICE")) {
			goal =  "getNoticeList.do";
		} else if(board.getCategory().equals("INFO")) {
			goal = "getInfoList.do";
		}
		return goal;
	}
	
}
