package com.shaba.student.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaba.student.model.Student;
import com.shaba.student.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	public List<Student>getStudents(){
		return studentRepository.findAll();
	}


	public void addNewStudent(Student student) {
		Optional<Student>studentEmail = studentRepository
				.findStudentByEmail(student.getEmail());
		if(studentEmail.isPresent()) {
			throw new IllegalStateException("email not available");
		}
		else {
		studentRepository.save(student);
		}
		// TODO Auto-generated method stub
		
	}



	public void deleteStudent(Long studentId) {
	boolean exists = studentRepository.existsById(studentId);
	if(!exists) {
		throw new IllegalStateException(
				"Student with id number:- " + studentId + " does not exist.");
	}
	else {
	studentRepository.deleteById(studentId);
	}
	
	}
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(()-> new IllegalStateException(
						"Student with id " + studentId + " does not exist"));
		if(name !=null && name.length()> 0 &&
				!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email !=null && email.length() > 0 &&
		!Objects.equals(student.getEmail(), email)){
			Optional<Student>studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}	

}
