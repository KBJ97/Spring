package ch05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.dto.UserDTO;

@Repository
public class User5DAO {
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public void insertUser5(UserDTO dto) {
		
		String sql = "INSERT INTO `User5` VALUES (?,?,?,?)";
		
		Object[] params = {
					dto.getUid(), 
					dto.getName(), 
					dto.getHp(), 
					dto.getAge()
					};
		
		
		jdbc.update(sql, params);
		
	}
	
	public UserDTO selectUser5(String uid) {
		String sql = "SELECT * FROM `User5` WHERE `uid`=?";
		UserDTO dto = jdbc.queryForObject(sql, new UserRowMapper(), uid);
		return dto;
	}
	
	public List<UserDTO> selectUser5s() {
		String sql = "SELECT * FROM `User5`";
		List<UserDTO> users = jdbc.query(sql, new UserRowMapper());
		return users;
	}
	
	public void updateUser5(UserDTO dto) {
		String sql = "UPDATE `User5` SET `name`=?, `hp`=? WHERE `uid`=?";
		Object[] params = {
				dto.getName(),
				dto.getHp(),
				dto.getAge(),
				dto.getUid()
		};
		jdbc.update(sql, params);
	}
	
	public void deleteUser5(String uid) {
		String sql = "DELETE FROM `User5` WHERE `uid`=?";
		jdbc.update(sql, uid);
	}
	
}