package com.student.project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.student.project.entity.Student;

import com.student.project.exception.StudentErrorResponse;
import com.student.project.service.StudentService;
import com.student.project.service.Studentvalidations;
@RestController

public class StudentController {

	@Autowired
	private StudentService studentService;

@PostMapping("/students")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		Studentvalidations validation=new Studentvalidations();
		StudentErrorResponse studenterrors=validation.vadiations(student);
	
		if(studenterrors==null){
			Student std=studentService.createStudent(student);
			ResponseEntity<Object> responseEntity=new ResponseEntity<Object>(std,HttpStatus.OK);
			return responseEntity;
			}
else
		{
		ResponseEntity<Object>responseEntity=new ResponseEntity<Object>(studenterrors,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
}
@PutMapping("/students")
public ResponseEntity<?> updateStudent(@RequestBody Student student) {
	Studentvalidations validation=new Studentvalidations();
	StudentErrorResponse studenterrors=validation.vadiations(student);

	if(studenterrors==null){
		Student std=studentService.updateStudent(student);
		ResponseEntity<Object> responseEntity=new ResponseEntity<Object>(std,HttpStatus.OK);
		return responseEntity;
		}
else
	{
	ResponseEntity<Object>responseEntity=new ResponseEntity<Object>(studenterrors,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}
@GetMapping("/students/{id}")
public ResponseEntity<?> getStudent(@PathVariable("id") int id){
    Student student = studentService.getStudent(id);
    if(student == null){
        return new ResponseEntity<>("it is not found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(student, HttpStatus.OK);
}

@GetMapping("/scores/{score}")
public ResponseEntity<?> getStudentByScore(@PathVariable int score) {
	if (score >= 0 && score <= 500) {
		List<Student> studentList = studentService.getStudentByScore(score);
		if (studentList != null && !studentList.isEmpty()) {
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		}
	}
	   return new ResponseEntity<String>("this score range is not found", HttpStatus.NOT_FOUND);
}


@GetMapping("/studentsssss")
public ResponseEntity<?> getStudentsByDateOfBirth(@RequestParam ("start")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam ("end")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
	if (startDate.isBefore(LocalDate.of(2000, 04, 20)) || endDate.isAfter(LocalDate.of(2002, 06, 20))) {
		return ResponseEntity.badRequest().body("Date of birth should be between 20th April 2000 and 20th Jun 2002");
	}
 List<Student> studentList = studentService.getStudentByDateOfBirth(startDate, endDate);
    if (studentList.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No students found for the given DateOfBirth range");
    }
    return ResponseEntity.ok(studentList);
}

@PostMapping("/bulkstudents")
public ResponseEntity<List<StudentErrorResponse>> createStudent(@RequestBody List<Student> student) {
	List<StudentErrorResponse> errorList = new ArrayList<StudentErrorResponse>();
	List<Student> createdlist=new ArrayList<Student>();
	for (Student student2 : student) {
		Studentvalidations validation=new Studentvalidations();
		StudentErrorResponse studenterrors=validation.vadiations(student2);
	
		if(studenterrors==null){
			createdlist.add(studentService.createStudent(student2));
			//ResponseEntity<List<StudentErrorResponse>> responseEntity=new ResponseEntity<List<StudentErrorResponse>>(HttpStatus.CREATED);
			//return responseEntity;
		}
		else
		{
			errorList.add(studenterrors);
		}
	}
	ResponseEntity<List<StudentErrorResponse>> responseEntity=new ResponseEntity<List<StudentErrorResponse>>(errorList,HttpStatus.BAD_REQUEST);
		return responseEntity;
	
}

}













