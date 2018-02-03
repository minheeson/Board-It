package com.sonandhan.boardit.service;

import java.util.List;

import com.sonandhan.boardit.dto.UserDTO;

public interface UserService {

	public List<UserDTO> selectMember() throws Exception;

	public void signupUser(UserDTO user);

	public UserDTO findByUserIdAndPassword(String userId, String password);
}
