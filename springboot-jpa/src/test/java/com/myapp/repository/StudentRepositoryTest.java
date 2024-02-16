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
	void saveStudent() {
		studentRepository.save(getStudent());
	}

	@Test
	void findAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}

	@Test
	void findByFirstNameContaining(String name) {
		studentRepository.findByFirstNameContaining("As");
	}

	@Test
	void findByLastNameNotNull() {
		studentRepository.findByLastNameNotNull();
	}

	@Test
	void findByGuardian(String guardianName) {
		studentRepository.findByGuardian("Lokesh");
	}

	@Test
	void findByFirstNameAndLastName(String firstName, String lastName) {
		studentRepository.findByFirstNameAndLastName("", "");
	}

	@Test
	void findStudentByEmailAddress(String emailAddress) {
		studentRepository.findStudentByEmailAddress("");
	};

}
