package io.github.marabezzi.crudbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.marabezzi.crudbackend.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	

}
