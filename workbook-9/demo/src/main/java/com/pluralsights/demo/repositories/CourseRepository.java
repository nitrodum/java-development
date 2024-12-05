package com.pluralsights.demo.repositories;


import com.pluralsights.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
