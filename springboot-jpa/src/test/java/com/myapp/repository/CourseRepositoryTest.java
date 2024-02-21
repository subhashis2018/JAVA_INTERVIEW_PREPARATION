package com.myapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.myapp.entity.Course;
import com.myapp.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	/*
	 * @Test void printCourses() { List<Course> courses =
	 * courseRepository.findAll(); System.out.println(courses); }
	 */
	@Test
	void saveCourseWithTeacher() {

		Teacher teacher = Teacher.builder().firstName("Subhas").lastName("Lokhande").build();

		Course course = Course.builder().title("Java").credit(5).teacher(teacher).build();
		courseRepository.save(course);
	}

	@Test
	void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

		long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

		System.out.println("totalElements: " + totalElements + "  totalPages: " + totalPages);

		// List<Course> courses =
		// courseRepository.findAll(firstPageWithThreeRecords).getContent();
		// System.out.println(courses);
	}

	void PaginationWithSorting() {
		Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());
		Pageable sortByTiteAndCreditDesc = PageRequest.of(0, 3, Sort.by("title").descending().and(Sort.by("credit")));

		//List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		//System.out.println("courses" + courses);
	}
}
