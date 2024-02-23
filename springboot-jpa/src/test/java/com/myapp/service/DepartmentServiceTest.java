package com.myapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.entity.Department;
import com.myapp.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() throws Exception {
		Department department=Department.builder()
				.departmentId(1L)
				.departmentName("Mechanical")
				.departmentAddress("Delhi")
				.departmentCode("09")
				.build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Mechanical")).thenReturn(department);
	}

	@DisplayName("GivenDepartmentName_WhenDepartmentExists_ThenReturnDepartment")
	@Test
	void fetchDepartmentByName() {
		String expected = "It";
		Department actual = departmentService.fetchByDepartmentName(expected);
		assertEquals(expected, actual.getDepartmentName());

	}

}
