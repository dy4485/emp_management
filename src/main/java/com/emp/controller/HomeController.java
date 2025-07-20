package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.emp.entity.Employee;
import com.emp.entity.User;
import com.emp.repository.EmpRepo;
import com.emp.repository.UserRepo;
import com.emp.service.Services;

//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class HomeController {
	@Autowired
	private Services empServices;
	
	@Autowired
	private UserRepo repo;
	 
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp = empServices.getAlaEmp();
		m.addAttribute("empp",emp);
		
		
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {

		return "add_emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e) {
	
	    empServices.addEmp(e);
//	    session.setAttribute("msg", "Employee Added Successfully");
	    return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		Employee emp=empServices.getEmpId(id);
		System.out.println(emp);
		m.addAttribute("emp", emp);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) {
		empServices.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String del(@PathVariable int id) {
		empServices.deleteEmp(id);
		
		return "redirect:/";
	}

}
