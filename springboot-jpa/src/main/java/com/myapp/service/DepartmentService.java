package com.myapp.service;

import java.util.List;

import com.myapp.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long id);

	public Department updateDepartment(Long id, Department department);

	public Department findByDepartmentName(String name);


}
