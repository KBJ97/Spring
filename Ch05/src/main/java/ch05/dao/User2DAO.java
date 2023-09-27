package ch05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.dto.UserDTO;

@Repository
public class User2DAO {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public void insertUser2(UserDTO dto) {
		
		String sql = "INSERT INTO `user2` VALUES (?,?,?,?)";
		
		Object[] params = {
					dto.getUid(), 
					dto.getName(), 
					dto.getHp(), 
					dto.getAge()
					};
		
		
		jdbc.update(sql, params);
		
	}
	
	public UserDTO selectUser2(String uid) {
		String sql = "SELECT * FROM `user2` WHERE `uid`=?";
		UserDTO dto = jdbc.queryForObject(sql, new UserRowMapper(), uid);
		return dto;
	}
	
	public List<UserDTO> selectUser2s() {
		String sql = "SELECT * FROM `user2`";
		List<UserDTO> users = jdbc.query(sql, new UserRowMapper());
		return users;
	}
	
	public void updateUser2(UserDTO dto) {
		String sql = "UPDATE `user2` SET `name`=?, `hp`=? WHERE `uid`=?";
		Object[] params = {
				dto.getName(),
				dto.getHp(),
				dto.getAge(),
				dto.getUid()
		};
		jdbc.update(sql, params);
	}
	
	public void deleteUser2(String uid) {
		String sql = "DELETE FROM `user2` WHERE `uid`=?";
		jdbc.update(sql, uid);
	}
	
}