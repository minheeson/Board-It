package com.sonandhan.boardit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sonandhan.boardit.dao.BoardDAO;
import com.sonandhan.boardit.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	@Override
	public void registBoard(BoardDTO board) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(board);
	}

	@Override
	public BoardDTO readBoardWithNum(Integer boardNum) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readBoardWithNum(boardNum);
	}

	@Override
	public List<BoardDTO> readBoardWithType(String boardType) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readBoardWithType(boardType);
	}

	@Override
	public List<BoardDTO> readBoard() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readBoard();
	}

	@Override
	public List<BoardDTO> readBoardWithUser(String boardUser) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl ::::: " + boardUser);
		return boardDAO.readBoardWithUser(boardUser);
	}

}
