package com.myapp.repository;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.entity.Guardian;
import com.myapp.entity.Student;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;

	Student getStudent() {
		return Student.builder().firstName("Ashok").lastName("Lenka").emailId("ashok@gmail.com").guardian(getGuardian())
				.build();
	}

	Guardian getGuardian() {
		return Guardian.builder().name("Lokesh Lenka").email("lokesh@gmail.com").mobile("12349999").build();
	}

	@Test
	@Order(0)
	@Disabled
	void saveStudentTest() {
		studentRepository.save(getStudent());
	}

	@Test
	@Disabled
	public void saveStudentWithGuardian() {

		Guardian guardian = Guardian.builder().email("sambit@gmail.com").name("Sambit").mobile("9999956324").build();

		Student student = Student.builder().firstName("Chintu").emailId("chintu@gmail.com").lastName("Kumar")
				.guardian(guardian).build();

		studentRepository.save(student);

	}

	@Test
	@Order(1)
	// @Disabled
	void findAllStudentTest() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}

	@Test
	@Order(2)
	// @Disabled
	void findByFirstNameTest() {
		studentRepository.findByFirstName("Ashok");
	}

	@Test
	@Order(3)
	// @Disabled
	void findByLastNameTest() {
		studentRepository.findByLastName("Lenka");
	}

	@Test
	@Order(4)
	// @Disabled
	void findByLastNameNotNullTest() {
		studentRepository.findByLastNameNotNull();
	}

	@Test
	@Order(5)
	// @Disabled
	void findByFirstNameContainingTest() {
		studentRepository.findByFirstNameContaining("Ash");
	}

	@Order(6)
	//@Disabled
	@Test
	void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Sambit");
		System.out.println("students = " + students);
	}

	@Order(7)
	//@Disabled
	@Test
	public void printgetStudentByEmailAddressNativeNamedParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("chintu@gmail.com");
		System.out.println("student = " + student);
	}

	@Order(8)
	//@Disabled
	@Test
	void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("chintu", "chintu@gmail.com");
	}

}
