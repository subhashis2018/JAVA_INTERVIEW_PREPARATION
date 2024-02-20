package com.myapp.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entity.CourseMaterial;

@Repository(value = "CourceMaterialRepository")
@Scope(value = "singleton")
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
