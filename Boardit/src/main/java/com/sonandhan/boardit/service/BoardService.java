package com.sonandhan.boardit.service;

import java.util.List;

import com.sonandhan.boardit.dto.BoardDTO;

public interface BoardService {

	public void registBoard(BoardDTO board) throws Exception;

	public BoardDTO readBoardWithNum(Integer boardNum) throws Exception;

	public List<BoardDTO> readBoardWithType(String boardType) throws Exception;

	public List<BoardDTO> readBoard() throws Exception;

}
