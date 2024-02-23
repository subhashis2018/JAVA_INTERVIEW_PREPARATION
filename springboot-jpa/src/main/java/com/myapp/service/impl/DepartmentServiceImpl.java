package com.myapp.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Department;
import com.myapp.repository.DepartmentRepository;
import com.myapp.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department dept = fetchDepartmentById(id);
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentRepository.save(dept);
	}

	@Override
	public Department fetchByDepartmentName(String name) {
		return departmentRepository.findByDepartmentName(name);
	}

	@Override
	public Department fetchByDepartmentNameIgnoreCase(String name) {
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
	}

}
