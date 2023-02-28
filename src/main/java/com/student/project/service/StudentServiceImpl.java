package com.student.project.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.project.entity.Student;
import com.student.project.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

public Student createStudent(Student student)  {

return studentRepo.save(student);
}
@Override
public List<Student> getAllStudents()  {
	// TODO Auto-generated method stub
	return studentRepo.findAll();
}
@Override
public Student updateStudent(Student student) {
	// TODO Auto-generated method stub
	return studentRepo.save(student);
}
@Override
public Student getStudent(int id) {
	// TODO Auto-generated method stub
	java.util.Optional<Student> student = studentRepo.findById(id);
	        if(student.isPresent()){
	            return student.get();
	        }
	        return null;
	    }
@Override
public List<Student> getStudentByScore(int score) {
	// TODO Auto-generated method stub
	return studentRepo.findByScore(score);
}
@Override
public List<Student> getStudentByDateOfBirth(LocalDate startDate, LocalDate endDate) {
	// TODO Auto-generated method stub
    return studentRepo.findAllByDateOfBirthBetween(startDate, endDate);
}
public List<Student> createStudent(List<Student> student) {
	List<Student> createdlist=new ArrayList<Student>();
	for (Student student2 : student) {
		createdlist.add(studentRepo.save(student));
	}
	return createdlist;
	
}

}


	





	



