package ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch05.dao.User2DAO;
import ch05.dto.UserDTO;

@Service
public class User2Service {
	
	@Autowired
	private User2DAO dao;
	
	public void insertUser2(UserDTO dto) {
		dao.insertUser2(dto);
	}
	
	public UserDTO selectUser2(String uid) {
		return dao.selectUser2(uid);
	}
	
	public List<UserDTO> selectUser2s() {
		return dao.selectUser2s();
	}
	
	public void updateUser2(UserDTO dto) {
		dao.updateUser2(dto);
	}
	
	public void deleteUser2(String uid) {
		dao.deleteUser2(uid);
	}
	
}