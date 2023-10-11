package com.demo.HibernateDemo;


import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.demo.HibernateDemo.entity.Course;
import com.demo.HibernateDemo.entity.Passport;
import com.demo.HibernateDemo.entity.Student;
import com.demo.HibernateDemo.repository.CourseRepository;
import com.demo.HibernateDemo.repository.PassportRepository;
import com.demo.HibernateDemo.repository.StudentRepository;
import com.demo.HibernateDemo.repository.StudentSpringDataRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner{

	@Autowired
	EntityManager em;
	
	@Autowired
	CourseRepository repo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	PassportRepository passportRepository;
	
	@Autowired
	StudentSpringDataRepository dataRepo;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		logger.info("adding student with passport:"+studentRepo.savePassportWithStudent());
		logger.info("get student with passport:"+studentRepo.findbyId(1));
		Passport passport = passportRepository.findbyId(30001);
		logger.info("get student with passport:"+passport);
		logger.info("student details from passport object:"+ passport.getStudent());
		
		//fetch data in many to many relationship
		Student student = studentRepo.findbyId(20003);
		logger.info("manyto many data->"+student.getCourses());
		
		//insert data in M2M relationship
		Student st = new Student("thorat");
		Course crs = new Course("jpa");
		st.addCourses(crs);
		em.persist(st);
		em.persist(crs);
		
		
		///using spring data repository
		//Sort sort = new Sort(D)
		Optional<Student> opstudent = dataRepo.findById(20001L);
		if(opstudent.isPresent()) {
			logger.info("jpa student data:"+opstudent.get());
		}
		
		//pagination
		PageRequest request = PageRequest.of(0, 3);
		Page<Student> page = dataRepo.findAll(request);
		logger.info("page data:"+page.getContent());
		/*
		 * logger.info("get by id:"+repo.findbyId(10001));
		 * logger.info("create entry:"+repo.save(new Course("caa")));
		 * logger.info("update entry:"+repo.save(new Course(10002, "kaveri")));
		 * repo.deleteById(10001); repo.playWithEntityManager();
		 */
	}

}
