package com.myapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entity.Department;
import com.myapp.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping("/department")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/department")
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/department/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long id) {
		return departmentService.fetchDepartmentById(id);
	}
	
	@GetMapping("/department/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String name) {
		return departmentService.fetchByDepartmentName(name);
	}
	
	@GetMapping("/department/nameIgnoreCase/{name}")
	public Department fetchDepartmentByNameIgnoreCase(@PathVariable("name") String name) {
		return departmentService.fetchByDepartmentNameIgnoreCase(name);
	}

	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}

}
