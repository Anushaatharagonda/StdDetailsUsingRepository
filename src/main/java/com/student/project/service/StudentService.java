package com.student.project.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.student.project.entity.Student;

public interface StudentService {

	Student createStudent(Student student);

	List<Student> getAllStudents();

	Student updateStudent(Student student);
Student getStudent(int id);

List<Student> getStudentByScore(int score);

List<Student> getStudentByDateOfBirth(LocalDate startDate, LocalDate endDate);














	
	
}
	