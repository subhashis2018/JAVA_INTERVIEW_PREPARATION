package com.myapp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "tbl_course")
public class Course {
	@Id
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	@Column(name = "courseId")
	private Long courseId;
	@Column(name = "course_title")
	private String title;
	private int credit;

	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
	private Teacher teacher;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="student_course_map",
			joinColumns = @JoinColumn(
					name="course_id",
					referencedColumnName = "courseId"
					),
			inverseJoinColumns = @JoinColumn(
					name="student_id",
					referencedColumnName = "studentId")
			)
	private List<Student> students;

}
