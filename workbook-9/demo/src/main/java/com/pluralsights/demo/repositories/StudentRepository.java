package com.pluralsights.demo.repositories;

import com.pluralsights.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
