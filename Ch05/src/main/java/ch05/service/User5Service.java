package ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch05.dao.User5DAO;
import ch05.dto.UserDTO;

@Service
public class User5Service {
	
	@Autowired
	private User5DAO dao;
	
	public void insertUser5(UserDTO dto) {
		dao.insertUser5(dto);
	}
	
	public UserDTO selectUser5(String uid) {
		return dao.selectUser5(uid);
	}
	
	public List<UserDTO> selectUser5s() {
		return dao.selectUser5s();
	}
	
	public void updateUser5(UserDTO dto) {
		dao.updateUser5(dto);
	}
	
	public void deleteUser5(String uid) {
		dao.deleteUser5(uid);
	}
	
}