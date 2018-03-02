package com.sonandhan.boardit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	public List<BoardDTO> readBoardWithUser(String boardUser) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl :::::: "+ boardUser);
		return sqlSession.selectList(namespace + ".selectBoardWithUser", boardUser);
	}

	@Override
	public BoardDTO readBoardWithNum(int boardNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectBoardWithNum", boardNum);
	}

	@Override
	public UserDTO findByUserIdAndPassword(String userId, String userPassword, HttpSession session) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("userPassword", userPassword);

		UserDTO user = new UserDTO("", userId, userPassword);
		int check = sqlSession.selectOne(namespace + ".checkUser", user);
		System.out.println("****DAO : " + check);

		if (check > 0) {
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUserName());
		} else {
			user = null;
		}
		return user;
	}

}
