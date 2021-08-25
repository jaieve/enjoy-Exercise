package com.enjoyexercise.www.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GreetingVO {
	private String greeting_id;
	private int dep;
	private String bundle_id;
	private String bundle_order;
	private String user_id;
	private String user_nickname;
	private String content;
	private boolean is_deleted;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	//paging 위해서 추가한 값
	private int startList;
	private int endList;
	
	
	public GreetingVO() {
	}

	public String getGreeting_id() {
		return greeting_id;
	}

	public void setGreeting_id(String greeting_id) {
		this.greeting_id = greeting_id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@JsonIgnore
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

	public GreetingVO(String greeting_id, int dep, String bundle_id, String bundle_order, String user_id,
			String user_nickname, String content, boolean is_deleted, String created_at, String updated_at,
			String deleted_at, int startList, int endList) {
		super();
		this.greeting_id = greeting_id;
		this.dep = dep;
		this.bundle_id = bundle_id;
		this.bundle_order = bundle_order;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.content = content;
		this.is_deleted = is_deleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.startList = startList;
		this.endList = endList;
	}

	@Override
	public String toString() {
		return "GreetingVO [greeting_id=" + greeting_id + ", dep=" + dep + ", bundle_id=" + bundle_id
				+ ", bundle_order=" + bundle_order + ", user_id=" + user_id + ", user_nickname=" + user_nickname
				+ ", content=" + content + ", is_deleted=" + is_deleted + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", deleted_at=" + deleted_at + ", startList=" + startList + ", endList=" + endList + "]";
	}

	
}
