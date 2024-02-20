package com.myapp.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Teacher;


@Repository(value = "TeacherRepository")
@Scope(value = "singleton")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
