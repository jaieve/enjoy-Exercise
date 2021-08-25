package com.enjoyexercise.www.vo;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {
	// users 테이블
	private String id;
	private String password;
	private String nicname;
	private String gender;
	private String role;
	private String newPW;
	private String checkPW;
	//personalinfo 테이블
	private String birthday;
	private float weight;
	private float height;
	private float bmi;
	private String sns;
	private String exercise;
	//프로필사진을 위한 필드
	private MultipartFile uploadFile;
	private String filename;
	private String originalfilename;
	
	public String getOriginalfilename() {
		return originalfilename;
	}
	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNicname() {
		return nicname;
	}
	public void setNicname(String nicname) {
		this.nicname = nicname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNewPW() {
		return newPW;
	}
	public void setNewPW(String newPW) {
		this.newPW = newPW;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", nicname=" + nicname + ", gender=" + gender + ", role="
				+ role + ", newPW=" + newPW + ", birthday=" + birthday + ", weight=" + weight + ", height=" + height
				+ ", bmi=" + bmi + ", sns=" + sns + ", exercise=" + exercise + ", uploadFile=" + uploadFile + ", filename="
				+ filename + "]";
	}
	
}
