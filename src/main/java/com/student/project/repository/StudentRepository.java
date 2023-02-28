package com.student.project.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	
	List<Student> findByScore(int score);

List<Student> findAllByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

Student save(List<Student> student);


	
}
