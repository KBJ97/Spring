package ch05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.dto.UserDTO;

@Repository
public class User4DAO {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public void insertUser4(UserDTO dto) {
		
		String sql = "INSERT INTO `User4` VALUES (?,?,?,?)";
		
		Object[] params = {
					dto.getUid(), 
					dto.getName(), 
					dto.getHp(), 
					dto.getAge()
					};
		
		
		jdbc.update(sql, params);
		
	}
	
	public UserDTO selectUser4(String uid) {
		String sql = "SELECT * FROM `User4` WHERE `uid`=?";
		UserDTO dto = jdbc.queryForObject(sql, new UserRowMapper(), uid);
		return dto;
	}
	
	public List<UserDTO> selectUser4s() {
		String sql = "SELECT * FROM `User4`";
		List<UserDTO> users = jdbc.query(sql, new UserRowMapper());
		return users;
	}
	
	public void updateUser4(UserDTO dto) {
		String sql = "UPDATE `User4` SET `name`=?, `hp`=? WHERE `uid`=?";
		Object[] params = {
				dto.getName(),
				dto.getHp(),
				dto.getAge(),
				dto.getUid()
		};
		jdbc.update(sql, params);
	}
	
	public void deleteUser4(String uid) {
		String sql = "DELETE FROM `User4` WHERE `uid`=?";
		jdbc.update(sql, uid);
	}
	
}