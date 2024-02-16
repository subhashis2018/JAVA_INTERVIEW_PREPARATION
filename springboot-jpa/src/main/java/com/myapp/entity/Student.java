package com.myapp.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
	@AttributeOverride(
			name="guardianName",
			column =@Column(name="guardianName")),
	@AttributeOverride(
			name="guardianEmail",
			column =@Column(name="guardianEmail")),
	@AttributeOverride(
			name="guardianMobile",
			column =@Column(name="guardianMobile"))
})
@Table(name = "TBL_STUDENT", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
public class Student {

	@Id
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	@Column(name = "studentId")
	private Long studentId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email", nullable = false)
	private String email;
	@Embedded
	private Guardian guardian;

}
