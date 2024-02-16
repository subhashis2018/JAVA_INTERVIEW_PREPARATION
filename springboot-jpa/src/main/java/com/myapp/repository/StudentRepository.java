package com.myapp.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Student;

import jakarta.transaction.Transactional;

@Repository(value = "StudentRepository")
@Scope(value = "singleton")
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardian(String guardianName);

	List<Student> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("select s from Student s where s.email=?1")
	Student findStudentByEmailAddress(String emailAddress);

	@Query("select s.firstName from Student s where s.email=?1")
	String findFirstNameByEmailAddress(String emailAddress);

	// Native Query
	@Query(value = "select * from tbl_student s where s.email=?1", nativeQuery = true)
	Student findStudentByEmailAddressNative(String emailAddress);

	// Native named parameter
	@Query(value = "select * from tbl_student s where s.email=:email", nativeQuery = true)
	Student findStudentByEmailAddressNaedParam(@Param("email") String emailAddress);

	@Modifying
	@Transactional
	@Query(value="update tbl_student set first_name=?1 where email=?2",nativeQuery = true)
	int updateStudentNameBYEmail(String firstName, String email);

}
