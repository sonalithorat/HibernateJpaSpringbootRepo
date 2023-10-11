package com.demo.HibernateDemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.HibernateDemo.entity.Passport;
import com.demo.HibernateDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	@Autowired
	PassportRepository pRepo;


	public Student findbyId(int id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(int id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}
	
	public Student save(Student student) {
		if(student.getId()==0) {
			em.persist(student);
			em.flush();
		}else {
			em.merge(student);
		}
		return student;
	}
	
	public Student savePassportWithStudent() {
		Passport passport = new Passport("Z23333");
		em.persist(passport);
		
		
		Student st = new Student("didi");
		st.setPassport_id(passport);
		em.persist(st);
		return st;
	}
	
	public void playWithEntityManager() {
		/*
		 * Student student1 = new Student("WebServices"); Student student2 = new
		 * Student("angular"); em.persist(student1); em.persist(student2); em.flush();
		 * em.clear(); student1.setName("python");
		 * 
		 * em.flush();
		 * 
		 * student2.setName("java"); em.flush();
		 */
	}
}
