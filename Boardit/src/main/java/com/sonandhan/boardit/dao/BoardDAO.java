package com.sonandhan.boardit.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sonandhan.boardit.dto.BoardDTO;
import com.sonandhan.boardit.dto.UserDTO;

public interface BoardDAO {

	
	public void insertBoard(BoardDTO boardDTO);
	public List<BoardDTO> readBoard() throws Exception;
	public List<BoardDTO> readBoardWithType(String boardType);
	public List<BoardDTO> readBoardWithUser(String boardUser) throws Exception;
	public BoardDTO readBoardWithNum(int boardNum);
	public UserDTO findByUserIdAndPassword(String userId, String userPassword, HttpSession session);
}
