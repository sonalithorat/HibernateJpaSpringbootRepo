package com.demo.HibernateDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	int id;
	
	@Column(nullable = false)
	String rating;
	String description;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course_id;
	
	public Review(int id, String rating, String description) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
	}
	
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Course course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}

}
