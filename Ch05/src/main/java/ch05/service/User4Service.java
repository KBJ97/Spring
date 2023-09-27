package ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch05.dao.User4DAO;
import ch05.dto.UserDTO;

@Service
public class User4Service {
	
	@Autowired
	private User4DAO dao;
	
	public void insertUser4(UserDTO dto) {
		dao.insertUser4(dto);
	}
	
	public UserDTO selectUser4(String uid) {
		return dao.selectUser4(uid);
	}
	
	public List<UserDTO> selectUser4s() {
		return dao.selectUser4s();
	}
	
	public void updateUser4(UserDTO dto) {
		dao.updateUser4(dto);
	}
	
	public void deleteUser4(String uid) {
		dao.deleteUser4(uid);
	}
	
}