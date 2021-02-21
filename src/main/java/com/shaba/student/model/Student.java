package com.shaba.student.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity(name = "Student")
@Table(
		name = "student",
		uniqueConstraints = {
				@UniqueConstraint(name="student_email_unique", columnNames="email")
		})
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			initialValue = 100,
			allocationSize = 1,
			sequenceName = "student_sequence")
	@GeneratedValue(
			 strategy = GenerationType.SEQUENCE,
			  generator = "student_sequence")
	
	@Column(name = "id",updatable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;
	
	@Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT" )
	private String email;
	
	@Column(name="dob", nullable = false)
	private LocalDate dob;
	
	@Transient
	int age;
	public Student(String name, String email, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Long id, String name, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
