package com.sonandhan.boardit.dao;

import java.util.List;

import com.sonandhan.boardit.dto.BoardDTO;

public interface BoardDAO {

	
	public void insertBoard(BoardDTO boardDTO);
	public List<BoardDTO> readBoard() throws Exception;
	public List<BoardDTO> readBoardWithType(String boardType);
	public BoardDTO readBoardWithNum(int boardNum);
}
