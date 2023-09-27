package ch06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ch06.dto.User2DTO;

@Mapper
@Repository
public interface User2Mapper {
	
	public void insertUser2(User2DTO dto);	
	public User2DTO selectUser2(String uid);	
	public List<User2DTO> selectUser2s();	
	public void updateUser2(User2DTO dto);	
	public void deleteUser2(String uid);
	
}