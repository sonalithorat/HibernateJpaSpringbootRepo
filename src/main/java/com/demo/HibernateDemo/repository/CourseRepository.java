package com.demo.HibernateDemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.HibernateDemo.entity.Course;
import com.demo.HibernateDemo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	
	public Course findbyId(int id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(int id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId()==0) {
			em.persist(course);
			em.flush();
		}else {
			em.merge(course);
		}
		return course;
	}
	
	public void addReviewsForCourse() {
		Course course = findbyId(10002);
		
		Review review1 = new Review("5", "nice");
		review1.setCourse_id(course);
		
		Review review2 = new Review("1", "need more detailed explaination");
		review2.setCourse_id(course);
		
		em.persist(review1);
		em.persist(review2);
	}
	public void playWithEntityManager() {
		Course course1 = new Course("WebServices");
		Course course2 = new Course("angular");
		em.persist(course1);
		em.persist(course2);
		em.flush();
		em.clear();
		course1.setName("python");
		
		em.flush();
	
		course2.setName("java");
		em.flush();
	}
}
