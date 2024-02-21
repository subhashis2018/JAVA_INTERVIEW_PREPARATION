package com.myapp.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.entity.Course;
import com.myapp.entity.CourseMaterial;
import com.myapp.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;

	public List<Course> getListOfCouses() {
		List<Course> courses = new ArrayList<Course>();

		Course course1 = Course.builder().title("Pyton").credit(2).build();
		CourseMaterial courseMaterial1 = CourseMaterial.builder().course(course1).url("www.google.com").build();

		Course course2 = Course.builder().title("Java").credit(5).build();
		CourseMaterial courseMaterial2 = CourseMaterial.builder().course(course2).url("www.yahoo.com").build();

		courses.add(course1);
		courses.add(course2);
		return courses;
	}

	/*
	 * @Test void saveTeacher() { //Teacher teacher =
	 * Teacher.builder().firstName("Anil").lastName("Kumblay").courses(
	 * getListOfCouses()).build(); //teacherRepository.save(teacher); }
	 */

	@Test
	void printAllTeacher() {
		List<Teacher> teachers = teacherRepository.findAll();
		System.out.println(teachers);
	}

}
