package com.myapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	@Disabled
	void saveCourceMaterial() {
		courseMaterialRepository.save(courseMaterial);
		// assertEquals(courseMaterialRepository.save(courseMaterial), courseMaterial);
	}

	@Test
	void getAllCourses() {
		List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
		System.out.println(courseMaterial);
		//assertEquals(courseMaterialRepository.findAll(),courseMaterial);
	}

}
