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

	List<Student> findByLastName(String lastName);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String guardianName);

	// Native Named Param

	@Query(value = "SELECT * FROM tbl_student s where s.email_address = :emailId", nativeQuery = true)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE tbl_student set first_name =:firstName where email_address =:emailId", nativeQuery = true)
	int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);

	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
	int updateStudentNameByEmailId1(String firstName, String emailId);
}
