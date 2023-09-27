package ch05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.dto.UserDTO;

@Repository
public class User3DAO {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public void insertUser3(UserDTO dto) {
		
		String sql = "INSERT INTO `User3` VALUES (?,?,?,?)";
		
		Object[] params = {
					dto.getUid(), 
					dto.getName(), 
					dto.getHp(), 
					dto.getAge()
					};
		
		
		jdbc.update(sql, params);
		
	}
	
	public UserDTO selectUser3(String uid) {
		String sql = "SELECT * FROM `User3` WHERE `uid`=?";
		UserDTO dto = jdbc.queryForObject(sql, new UserRowMapper(), uid);
		return dto;
	}
	
	public List<UserDTO> selectUser3s() {
		String sql = "SELECT * FROM `User3`";
		List<UserDTO> users = jdbc.query(sql, new UserRowMapper());
		return users;
	}
	
	public void updateUser3(UserDTO dto) {
		String sql = "UPDATE `User3` SET `name`=?, `hp`=? WHERE `uid`=?";
		Object[] params = {
				dto.getName(),
				dto.getHp(),
				dto.getAge(),
				dto.getUid()
		};
		jdbc.update(sql, params);
	}
	
	public void deleteUser3(String uid) {
		String sql = "DELETE FROM `User3` WHERE `uid`=?";
		jdbc.update(sql, uid);
	}
	
}