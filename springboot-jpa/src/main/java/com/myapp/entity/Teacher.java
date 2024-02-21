package com.myapp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_teacher")
public class Teacher {
	@Id
	@SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
	@Column(name = "teacherId")
	private Long teacherId;
	private String firstName;
	private String lastName;
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId") private
	 * List<Course> courses;
	 */

}
