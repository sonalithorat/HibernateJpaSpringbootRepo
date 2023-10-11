package com.demo.HibernateDemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.HibernateDemo.entity.Passport;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PassportRepository {

	@Autowired
	EntityManager em;
	
	
	public Passport findbyId(int id) {
		return em.find(Passport.class, id);
	}
	
	public void deleteById(int id) {
		Passport passport = em.find(Passport.class, id);
		em.remove(passport);
	}
	
	public Passport save(Passport passport) {
		if(passport.getId()==0) {
			em.persist(passport);
			em.flush();
		}else {
			em.merge(passport);
		}
		return passport;
	}
	
	public void playWithEntityManager() {
		/*
		 * Passport passport1 = new Passport("WebServices"); Passport passport2 = new
		 * Passport("angular"); em.persist(passport1); em.persist(passport2); em.flush();
		 * em.clear(); passport1.setName("python");
		 * 
		 * em.flush();
		 * 
		 * passport2.setName("java"); em.flush();
		 */
	}
}
