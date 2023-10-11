package com.demo.HibernateDemo.repository;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.HibernateDemo.HibernateDemoApplication;
import com.demo.HibernateDemo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@SpringBootTest(classes= HibernateDemoApplication.class)
public class QueryTest {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired EntityManager em;
	@Test
	public void testCriteria() {
		TypedQuery<Course> query = em.createQuery("select c from course", Course.class);
		List list = query.getResultList();
		logger.info("typed query:"+list);
	}
}
