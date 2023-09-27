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
import ch05.service.User4Service;

@Controller
public class User4Controller {

	@Autowired
	private User4Service service;
	
	@GetMapping("/user4/register")
	public String register() {		
		return "/user4/register";
	}
	
	@PostMapping("/user4/register")
	public String register(UserDTO dto) {
		service.insertUser4(dto);
		return "redirect:/user4/list";
	}
	
	@GetMapping("/user4/list")
	public String list(Model model) {
		
		List<UserDTO> users = service.selectUser4s();
		model.addAttribute("users", users);	
		return "/user4/list";
	}
	
	@GetMapping("/user4/modify")
	public String modify(@RequestParam("uid") String uid, Model model) {
		
		UserDTO user = service.selectUser4(uid);
		model.addAttribute(user);
		
		return "/user4/modify";
	}
	
	@PostMapping("/user4/modify")
	public String modify(@ModelAttribute UserDTO dto) {
		service.updateUser4(dto);
		return "redirect:/user4/list";
	}
	
	@GetMapping("/user4/delete")
	public String delete(String uid) {
		service.deleteUser4(uid);
		return "redirect:/user4/list";
	}
	
}