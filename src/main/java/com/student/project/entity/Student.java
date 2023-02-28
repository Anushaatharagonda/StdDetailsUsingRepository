package com.student.project.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private LocalDate dateOfBirth;
	private int score;
	private double percentage;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", DateOfBirth=" + dateOfBirth + ", score=" + score
				+ ", percentage=" + percentage + "]";
	}
	
}
