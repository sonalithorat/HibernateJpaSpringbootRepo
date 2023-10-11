package com.demo.HibernateDemo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
/*
 * @NamedQueries(value= {
 * 
 * @NamedQuery(name = "native_query", query = "select s from student s")})
 */
@RepositoryRestResource(path="/student")
public class Student {

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false)
	String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "passport_id", referencedColumnName = "id")
	Passport passport_id;

	@ManyToMany
	@JoinTable(name = "Student_course", joinColumns = @JoinColumn(name = "student_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses = new ArrayList<Course>();

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport_id() {
		return passport_id;
	}

	public void setPassport_id(Passport passport_id) {
		this.passport_id = passport_id;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course courses) {
		this.courses.add(courses);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport_id=" + passport_id + "]";
	}

}
