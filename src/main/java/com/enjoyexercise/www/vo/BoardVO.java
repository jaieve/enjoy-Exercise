package com.enjoyexercise.www.vo;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private String category;
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String contentType;
	private String regdate;
	private int cnt;
	private int commentCnt;
	//검색을 위해 추가한 값 ------------
	private String searchType;
	private String searchKeyword;
	//-------------
	private MultipartFile uploadFile;
	private String filename;
	//------------------
	private int is_deleted;
	//paging 위해서 추가한 값
	private int startList;
	private int endList;
	public BoardVO() {
	}
	
	public BoardVO(String category,int seq, String title, String writer, String content, String contentType, String regdate, int cnt,
			String searchType, String searchKeyword, MultipartFile uploadFile, String filename, int startList,
			int endList, int commentCnt, int is_deleted) {
		super();
		this.category = category;
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.contentType = contentType;
		this.regdate = regdate;
		this.cnt = cnt;
		this.searchType = searchType;
		this.searchKeyword = searchKeyword;
		this.uploadFile = uploadFile;
		this.filename = filename;
		this.startList = startList;
		this.endList = endList;
		this.commentCnt = commentCnt;
		this.is_deleted = is_deleted;
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCommentCnt() {
		return commentCnt;
	}
	
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getStartList() {
		return startList;
	}

	public void setStartList(int startList) {
		this.startList = startList;
	}

	public int getEndList() {
		return endList;
	}

	public void setEndList(int endList) {
		this.endList = endList;
	}
	
	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "BoardVO [category=" + category + ", seq=" + seq + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", contentType=" + contentType + ", regdate=" + regdate + ", cnt=" + cnt
				+ ", commentCnt=" + commentCnt + ", searchType=" + searchType + ", searchKeyword=" + searchKeyword
				+ ", uploadFile=" + uploadFile + ", filename=" + filename + ", is_deleted=" + is_deleted
				+ ", startList=" + startList + ", endList=" + endList + "]";
	}

}
