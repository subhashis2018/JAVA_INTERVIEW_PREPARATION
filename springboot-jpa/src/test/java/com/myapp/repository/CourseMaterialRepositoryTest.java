package com.myapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.entity.Course;
import com.myapp.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	Course course;
	CourseMaterial courseMaterial;

	@BeforeEach
	void setup() {
		course = Course.builder().courseId(1L).title("Effective Java").build();
		courseMaterial = CourseMaterial.builder().courseMterialId(1L).course(course).url("www.google.com").build();
		//System.out.println(courseMaterial);
	}
	
	public List<CourseMaterial> getListOfCourseMaterials() {
		List<CourseMaterial> courseMaterial = new ArrayList<CourseMaterial>();

		Course course1 = Course.builder().title("Pyton").credit(2).build();
		CourseMaterial courseMaterial1 = CourseMaterial.builder().course(course1).url("www.google.com").build();

		Course course2 = Course.builder().title("Java").credit(5).build();
		CourseMaterial courseMaterial2 = CourseMaterial.builder().course(course2).url("www.yahoo.com").build();

		courseMaterial.add(courseMaterial1);
		courseMaterial.add(courseMaterial2);
		return courseMaterial;
	}

	@Test
	@Disabled
	void saveCourceMaterial() {
		courseMaterialRepository.saveAll(getListOfCourseMaterials());
		// assertEquals(courseMaterialRepository.save(courseMaterial), courseMaterial);
	}

	@Test
	void getAllCourses() {
		List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
		System.out.println(courseMaterial);
		//assertEquals(courseMaterialRepository.findAll(),courseMaterial);
	}

}
