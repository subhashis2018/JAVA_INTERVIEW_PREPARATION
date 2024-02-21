package com.myapp.entity;

import java.net.URL;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@ToString(exclude = "")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_course_material")
public class CourseMaterial {
	@Id
	@SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
	@Column(name = "courseMaterialId")
	private Long courseMterialId;
	@Column(name = "courseMaterialUrl")
	private String url;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "courseId")
	private Course course;

}
