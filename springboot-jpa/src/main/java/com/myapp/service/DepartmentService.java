package com.myapp.service;

import java.util.List;
import java.util.Optional;

import com.myapp.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Optional<Department> fetchDepartmentById(Long id);

	public Department updateDepartment(Long id, Department department);

	public Department fetchByDepartmentName(String name);

	public Department fetchByDepartmentNameIgnoreCase(String name);



}
