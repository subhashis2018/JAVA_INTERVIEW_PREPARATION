package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entity.Department;
import com.myapp.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	/*
	 * public Department saveDepartment(Department department) {
	 * 
	 * }
	 */

}
