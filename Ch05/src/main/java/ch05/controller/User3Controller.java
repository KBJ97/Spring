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
import ch05.service.User3Service;

@Controller
public class User3Controller {

	@Autowired
	private User3Service service;
	
	@GetMapping("/user3/register")
	public String register() {		
		return "/user3/register";
	}
	
	@PostMapping("/user3/register")
	public String register(UserDTO dto) {
		service.insertUser3(dto);
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/list")
	public String list(Model model) {
		
		List<UserDTO> users = service.selectUser3s();
		model.addAttribute("users", users);	
		return "/user3/list";
	}
	
	@GetMapping("/user3/modify")
	public String modify(@RequestParam("uid") String uid, Model model) {
		
		UserDTO user = service.selectUser3(uid);
		model.addAttribute(user);
		
		return "/user3/modify";
	}
	
	@PostMapping("/user3/modify")
	public String modify(@ModelAttribute UserDTO dto) {
		service.updateUser3(dto);
		return "redirect:/user3/list";
	}
	
	@GetMapping("/user3/delete")
	public String delete(String uid) {
		service.deleteUser3(uid);
		return "redirect:/user3/list";
	}
	
}