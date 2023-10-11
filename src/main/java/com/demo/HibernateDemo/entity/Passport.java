package com.demo.HibernateDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false)
	String number;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport_id")
	private Student student;

	public Passport() {
		super();
	}

	public Passport(int id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}

}
