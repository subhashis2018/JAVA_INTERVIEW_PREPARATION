package com.myapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.myapp.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentId(1L).departmentName("Mechanical")
				.departmentAddress("Delhi").departmentCode("09").build();
		testEntityManager.persist(department);
	}

	@Test
	void whenFindByIdThenReturnDepartment() {
		Department department = departmentRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(), "Mechanical");
	}

}
