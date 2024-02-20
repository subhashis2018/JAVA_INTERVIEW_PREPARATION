package com.myapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.entity.Course;
import com.myapp.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	CourseMaterialRepository courseMaterialRepository;

	@Test
	void saveCourceMaterial() throws MalformedURLException {
		Course course = Course.builder().title("Effective Java").build();
		CourseMaterial courseMaterial = CourseMaterial.builder().course(course).url(new URL("www.google.com")).build();
		courseMaterialRepository.save(courseMaterial);
		//assertEquals(courseMaterialRepository.save(courseMaterial), courseMaterial);
	}

}
