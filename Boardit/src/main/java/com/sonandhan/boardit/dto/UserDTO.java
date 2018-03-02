package com.sonandhan.boardit.dto;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class UserDTO {

	private String userId;
	private String userPassword;
	private String userName;
	private String userImg;

	public UserDTO(String userName, String userId, String userPassword) {
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public UserDTO(String userId, String userPassword) {
		this.userName = null;
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}



}
