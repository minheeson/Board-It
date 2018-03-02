package com.sonandhan.boardit.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sonandhan.boardit.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.example.mapper.userMapper";

	@Override
	public List<UserDTO> selectMember() throws Exception {

		return sqlSession.selectList(Namespace + ".selectUser");
	}

	@Override
	public int insertMember(UserDTO user) {

		return sqlSession.insert(Namespace + ".insertUser", user);
	}

	@Override
	public UserDTO findByUserIdAndPassword(String userId, String password, HttpSession session) {
		// TODO Auto-generated method stub
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("userPassword", password);

		UserDTO user = new UserDTO("", userId, password);
		int check = sqlSession.selectOne(Namespace + ".checkUser", user);
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
