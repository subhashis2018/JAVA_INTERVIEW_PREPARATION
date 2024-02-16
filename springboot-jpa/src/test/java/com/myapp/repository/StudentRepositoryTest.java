package com.myapp.repository;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.entity.Guardian;
import com.myapp.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	Student getStudent() {
		return Student.builder().firstName("Ashok").lastName("Lenka").email("ashok@gmail.com").guardian(getGuardian())
				.build();
	}

	Guardian getGuardian() {
		return Guardian.builder().guardianName("Lokesh Lenka").guardianEmail("lokesh@gmail.com")
				.guardianMobile("12349999").build();
	}

	@Test
	@Disabled
	void saveStudentTest() {
		studentRepository.save(getStudent());
	}

	@Test
	void findAllStudentTest() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}

	@Test
	void findByFirstNameContainingTest(String name) {
		studentRepository.findByFirstNameContaining("As");
	}

	@Test
	void findByLastNameNotNullTest() {
		studentRepository.findByLastNameNotNull();
	}

	@Test
	void findByGuardianTest(String guardianName) {
		studentRepository.findByGuardian("Lokesh");
	}

	@Test
	void findByFirstNameAndLastNameTest(String firstName, String lastName) {
		studentRepository.findByFirstNameAndLastName("Ashok", "Lenka");
	}

	@Test
	void findStudentByEmailAddressTest(String emailAddress) {
		studentRepository.findStudentByEmailAddress("ashok@gmail.com");
	}
	
	@Test
	void updateStudentNameBYEmailTest(String firstName, String email) {
		studentRepository.updateStudentNameBYEmail("Ashok","ashok@gmail.com");
	}

}
