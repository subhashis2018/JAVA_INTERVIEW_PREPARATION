package com.myapp.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Department;

@Repository(value = "DepartmentRepository")
@Scope(value = "singleton")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	//public Department updateDepartment(Long id, Department department);

}
