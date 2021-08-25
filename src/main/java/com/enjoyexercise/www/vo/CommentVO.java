package com.enjoyexercise.www.vo;

public class CommentVO {
	private String reply_id;
	//댓글의 unique한 키
	private int board_id;
	//댓글이 달린 게시글의 id
	//notice or information 의 seq 컬럼과 이어진다.
	private int dep;
	//대댓글을 표시하기 위해 쓰는 깊이 또는 위치
	//원댓글은 0, 대댓글은 1
	private String bundle_id;
	//대댓글이 달려있는 댓글이 삭제된 경우 대댓글도 삭제되어야 한다.(실제로는 is_deleted로 숨기는 것)
	//이를 연결시켜줄 수 있는 정보로, 댓글과 대댓글을 묶어주는 id
	//ascending으로 증가하는 값이어야 UI상에서 정렬해서 보여줄 때 편하다. DB에서 unique 옵션이 없으면 timestampe 값을 공유해서 bundle_id값으로 사용할 수 밖에 없다.
	//millisecond 시간 값을 bundle_id에 저장
	
	private String bundle_order;
	//답글의 깊이 또는 위치를 정한다. 0 또는 1
	//0=false, 1=true
	//???????이해가 안되네
	//같은 묶음인 bundle 안에서도 순서를 정해줄 수 있어야 하기 때문에 순서의 기준이 되는 값이 필요해서 정의한 값.
	//중복이 발생할 확률이 적도록 millisecond단위로 시간을 bundle_order에 저장
	//bundle_order에 따라 ascending 순서로 UI에서 정렬해서 보여주면 됨.
	private String user_id;
	//댓글 작성한 id
	private String user_nickname;
	//댓글 작성한 nickname
	private String reply;
	//댓글 내용
	private boolean is_deleted;
	//true인 경우 "삭제된 글입니다"로 표현하기도 한다.
	private String created_at;
	//작성된 시간. 오라클 테이블에서는 timestamp 자료형에 default 값은 sysdate
	private String updated_at;
	//업데이트된 시간
	private String deleted_at;
	//삭제된 시간
	private String category;
	//insertReply 할 때 현재 시간을 createdTimeStamp 라는 String 변수에 담는다.
		//게시판에 댓글을 작성할 때는 bundle_id에 현재 시간을 쓴다. 그리고 depth=0, bundle_order=0(false)의 값을 저장
		//reply_id = 밀리초단위 시간, board_id = ${board.seq}, depth=0
		//대댓글은 상위 댓글이 있는가?(bundle_id=!0=1)로 구분할 수 있고, 해당 댓글과 연결된다.
		//해당 댓글의 여러 대댓글안에서 각 대댓글을 구분짓는 unique한 값은 bundle_order에 저장된 millisecond 값이다.
		//그리고 대댓글의 depth는 1, bundel_id를 상위댓글의 값을 상속받아 저장, bundle_order는 대댓글이 작성된시간의 millisecond값
		//추후 db에서 가져와서 순서대로 정렬할 때는 대댓글 중에서 첫번째 인 것은 bundle_order에 저장되는 millisecond 값을 이용
		//대댓글의 경우 저장되는 값
	public CommentVO() {
	}
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public String getBundle_id() {
		return bundle_id;
	}
	public void setBundle_id(String bundle_id) {
		this.bundle_id = bundle_id;
	}
	public String getBundle_order() {
		return bundle_order;
	}
	public void setBundle_order(String bundle_order) {
		this.bundle_order = bundle_order;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public CommentVO(String reply_id, int board_id, int dep, String bundle_id, String bundle_order, String user_id,
			String user_nickname, String reply, boolean is_deleted, String created_at, String updated_at,
			String deleted_at, String category) {
		super();
		this.reply_id = reply_id;
		this.board_id = board_id;
		this.dep = dep;
		this.bundle_id = bundle_id;
		this.bundle_order = bundle_order;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.reply = reply;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.category = category;
		
	}
	@Override
	public String toString() {
		return "CommentVO [reply_id=" + reply_id + ", board_id=" + board_id + ", dep=" + dep + ", bundle_id="
				+ bundle_id + ", bundle_order=" + bundle_order + ", user_id=" + user_id + ", user_nickname=" + user_nickname
				+ ", reply=" + reply + ", is_deleted=" + is_deleted + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", deleted_at=" + deleted_at +", category=" + category + "]";
	}
}
