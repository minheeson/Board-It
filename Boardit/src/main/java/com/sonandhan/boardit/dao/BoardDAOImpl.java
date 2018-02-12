package com.sonandhan.boardit.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sonandhan.boardit.dto.BoardDTO;
import com.sonandhan.boardit.dto.UserDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.example.mapper.boardMapper";

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertBoard", boardDTO);
	}

	@Override
	public List<BoardDTO> readBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectBoard");
	}

	@Override
	public List<BoardDTO> readBoardWithType(String boardType) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectBoardWithType", boardType);
	}

	@Override
	public BoardDTO readBoardWithNum(int boardNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectBoardWithNum", boardNum);
	}

}
