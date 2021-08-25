package com.enjoyexercise.www.vo;

public class PagingVO {
	private int listSize=5;
	private int rangeSize=5;
	private int page;
	private int range;
	private int listCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int endPage;
	private int endList;
	private boolean prev;
	private boolean next;
	public PagingVO() {
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangesize() {
		return rangeSize;
	}
	public void setRangesize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getListCnt() {
		return listCnt;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int starPage) {
		this.startPage = starPage;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getEndList() {
		return endList;
	}
	public void setEndList(int endList) {
		this.endList = endList;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		//전체 페이지 수 계산
		this.pageCnt = (int) Math.ceil((double)listCnt/(double)listSize);
		//구간의 시작페이지
		this.startPage = (range-1) * rangeSize +1;
		//구간의 끝 페이지
		this.endPage = range * rangeSize;
		//게시판 시작번호
		this.startList = (page - 1) * listSize + 1;
		//게시판 마지막 번호
		this.endList = page * listSize;
		//이전 버튼 상태
		this.prev = range == 1 ? false : true;
		//다음 버튼 상태 : 10 > 6
		this.next = endPage >= pageCnt ? false : true;
		if (this.endPage >= this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
	@Override
	public String toString() {
		return "PagingVO [listSize=" + listSize + ", rangeSize=" + rangeSize + ", page=" + page + ", range=" + range
				+ ", listCnt=" + listCnt + ", pageCnt=" + pageCnt + ", startPage=" + startPage + ", startList="
				+ startList + ", endPage=" + endPage + ", endList=" + endList + ", prev=" + prev + ", next=" + next
				+ "]";
	}
}
