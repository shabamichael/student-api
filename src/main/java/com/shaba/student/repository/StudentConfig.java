package com.shaba.student.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shaba.student.model.Student;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args->
		{
			Student michael =new Student(
					"Michael",
					"shaba@mike.com",
					LocalDate.of(2000, Month.APRIL, 20));
			
			Student Joy =new Student(
					"Joy",
					"shabaranks@mike.com",
					LocalDate.of(1998, Month.APRIL, 20));
			
			studentRepository.saveAll(
					List.of(michael, Joy));
		}
		;
		
	}

}
