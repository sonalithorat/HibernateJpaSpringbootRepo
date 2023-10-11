package com.demo.HibernateDemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false)
	String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course_id")
	private List<Review> review = new ArrayList<Review>();

	@ManyToMany(mappedBy = "courses")
	private List<Student> student = new ArrayList<Student>();

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	protected Course() {

	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReview() {
		return review;
	}

	public void addReview(Review review) {
		this.review.add(review);
	}

	public void removeReview(Review review) {
		this.review.remove(review);
	}

	public List<Student> getStudent() {
		return student;
	}

	public void addStudent(Student student) {
		this.student.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
