package com.student.project.service;

import java.time.LocalDate;

import com.student.project.entity.Student;

import com.student.project.exception.StudentErrorResponse;

public class Studentvalidations {

	public StudentErrorResponse vadiations(Student student) {
	
		StudentErrorResponse studenterrors=null;
		
		if(student.getName().length() > 25) {
			
	studenterrors= new StudentErrorResponse();
			studenterrors.setStudentErrorCode(878);
			studenterrors.setStudentErrorMessage("The Product name below 25 characters");

		   }
		
		if(!student.getName().matches("[a-zA-Z ]+")) {
			
			studenterrors= new StudentErrorResponse();
					studenterrors.setStudentErrorCode(2000);
					studenterrors.setStudentErrorMessage("Name should only contain alphabets and spaces.");
					return studenterrors;
		}

		
		if(student.getDateOfBirth().isBefore(LocalDate.of(2000,04, 20))||(student.getDateOfBirth().isAfter(LocalDate.of(2002,06,20)))){
			studenterrors= new StudentErrorResponse();
			studenterrors.setStudentErrorMessage("Date of Birth should be between 20th April 2000 and 20th June 2002.");
			return studenterrors;
			
		}
		if(student.getScore() > 500 || student.getScore() < 0) {
			studenterrors=new StudentErrorResponse();
			studenterrors.setStudentErrorCode(877);
			
			studenterrors.setStudentErrorMessage("Score should be between 0 and 500.");
			return studenterrors;
			}

		if(student.getPercentage() > 10 || student.getPercentage() < 0) {
			studenterrors= new StudentErrorResponse();
			studenterrors.setStudentErrorCode(888);
			studenterrors.setStudentErrorMessage("Percentage should be between 0 and 10.");
			return studenterrors;
			}
		return studenterrors;
	}

	}


