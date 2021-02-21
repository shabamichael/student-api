package com.shaba.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shaba.student.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT s FROM Student s WHERE s.email = ?1")
	public abstract Optional<Student>findStudentByEmail(String email);

}
