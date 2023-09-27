package ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch05.dao.User3DAO;
import ch05.dto.UserDTO;

@Service
public class User3Service {
	
	@Autowired
	private User3DAO dao;
	
	public void insertUser3(UserDTO dto) {
		dao.insertUser3(dto);
	}
	
	public UserDTO selectUser3(String uid) {
		return dao.selectUser3(uid);
	}
	
	public List<UserDTO> selectUser3s() {
		return dao.selectUser3s();
	}
	
	public void updateUser3(UserDTO dto) {
		dao.updateUser3(dto);
	}
	
	public void deleteUser3(String uid) {
		dao.deleteUser3(uid);
	}
	
}