package ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch05.dto.UserDTO;
import ch05.service.User2Service;

@Controller
public class User2Controller {

	@Autowired
	private User2Service service;
	
	@GetMapping("/user2/register")
	public String register() {		
		return "/user2/register";
	}
	
	@PostMapping("/user2/register")
	public String register(UserDTO dto) {
		service.insertUser2(dto);
		return "redirect:/user2/list";
	}
	
	@GetMapping("/user2/list")
	public String list(Model model) {
		
		List<UserDTO> users = service.selectUser2s();
		model.addAttribute("users", users);	
		return "/user2/list";
	}
	
	@GetMapping("/user2/modify")
	public String modify(@RequestParam("uid") String uid, Model model) {
		
		UserDTO user = service.selectUser2(uid);
		model.addAttribute(user);
		
		return "/user2/modify";
	}
	
	@PostMapping("/user2/modify")
	public String modify(@ModelAttribute UserDTO dto) {
		service.updateUser2(dto);
		return "redirect:/user2/list";
	}
	
	@GetMapping("/user2/delete")
	public String delete(String uid) {
		service.deleteUser2(uid);
		return "redirect:/user2/list";
	}
	
}