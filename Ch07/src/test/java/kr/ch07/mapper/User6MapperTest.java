package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User6MapperTest {

	@Autowired
	private User6Mapper mapper;
	
	public void insertUser6() {
		
		User6DTO user1 = User6DTO.builder()
				.uid("A101")
				.name("홍길동")
				.hp("010-1234-1001")
				.age(33)
				.build();
		
		mapper.insertUser6(user1);
	}
	
	public User6DTO selectUser6(String uid) {
		return null;
	}
	
	@Test
	public void selectUser6s(){
		List<User6DTO> users = mapper.selectUser6s();
		
		for(User6DTO user : users) {
			log.info(user.toString());
		}
	}
	
	@Test
	public void updateUser6() {
		log.info("updateUser6 ...");
	}
	
	public void deleteUser6(String uid) {
		
	}
}