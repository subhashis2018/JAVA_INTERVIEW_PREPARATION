package com.myapp.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Course;


@Repository(value = "CourseRepository")
@Scope(value = "singleton")
public interface CourseRepository extends JpaRepository<Course, Long> {

}
