package com.emp.service;

import com.emp.entity.Employee;
import com.emp.repository.EmpRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
	@Autowired
	private EmpRepo repo;
	
	public List<Employee> getAlaEmp(){
		return repo.findAll();
	}
	
	public void addEmp(Employee e) {
		 repo.save(e);
		 
	}
	
	public Employee getEmpId(int id) {
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	
	}
	public void deleteEmp(int id) {
		 repo.deleteById(id);
	}

}
