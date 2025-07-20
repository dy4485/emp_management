package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.emp.entity.Employee;
import com.emp.entity.User;
import com.emp.repository.UserRepo;
import com.emp.service.Services;

import jakarta.servlet.http.HttpSession;

@Controller
public class CardController {

	@Autowired
	private Services empServices;
	
	@Autowired
	private UserRepo repo;
	
	@GetMapping("/getcard")
	public String getCard(Model m) {
		List<Employee> list =empServices.getAlaEmp();
		m.addAttribute("list", list);
		return "card";
		
	}
	@GetMapping("/adduser")
	public String addUser(@RequestBody User u,HttpSession http) {
//		http.setAttribute("user", u);
		String name=u.getUsername();

		if(repo.existsByUsername(name)) {
			return "card";
		}
		repo.save(u);
		return "index";
	
	}
}
