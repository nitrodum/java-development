package com.pluralsights.demo.services;


import com.pluralsights.demo.models.Course;
import com.pluralsights.demo.models.Student;
import com.pluralsights.demo.repositories.CourseRepository;
import com.pluralsights.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    CourseRepository courseRepository;
    StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }


    public List<Course> getAllCourses() {
        return this.courseRepository.findAll();
    }


    public Course getCourseById(int id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        Course c = new Course();
        c.setName(course.getName());
        c.setDescription(course.getDescription());
        c.setAvgGrade(course.getAvgGrade());
        return this.courseRepository.save(c);
    }

    public Course addStudentToCourse(int courseId, long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        course.getStudents().add(student);
        student.getCourses().add(course);

        studentRepository.save(student);
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course, int id) {
        Course c = getCourseById(id);
        c.setName(course.getName());
        c.setDescription(course.getDescription());
        c.setAvgGrade(course.getAvgGrade());
        return this.courseRepository.save(c);
    }

    public void delete(int id) {
        this.courseRepository.deleteById(id);
    }
}
