package com.sonandhan.boardit.dto;

public class BoardDTO {

	private String boardUser;
	private int boardNum;
	private String boardName;
	private String boardType;

	public BoardDTO(String boardUser, String boardName, String boardType) {
		this.boardUser = boardUser;
		this.boardName = boardName;
		//this.boardNum = boardNum;
		this.boardType = boardType;
	}
	
	public BoardDTO(String boardUser, Integer boardNum, String boardName, String boardType) {
		this.boardUser = boardUser;
		this.boardName = boardName;
		this.boardNum = boardNum;
		this.boardType = boardType;
	}
	
	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", boardName=" + boardName + ", boardType=" + boardType + "]";
	}

}
