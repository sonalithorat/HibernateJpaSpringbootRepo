package com.demo.HibernateDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.HibernateDemo.entity.Student;

@Repository
public interface StudentSpringDataRepository extends JpaRepository<Student, Long>{

	//some custom queries in jpa
	List<Student> findByName(String name);
	
	List<Student> countByName(String name);
	
	List<Student> findByNameOrderByIdDesc(String name);
	
	void deleteById(Long id);
	
	/*
	 * @Query("select s from student s where name like '%jpa%'") List<Student>
	 * courseWithJPAInName();
	 */
	
	@Query(value ="select * from student where name like '%jpa%'", nativeQuery = true)
	List<Student> StudentWithJPAName();
	
	/*
	 * //@Query(name ="native_query") List<Student> StudentWithJPANameNativeQuery();
	 */
}
