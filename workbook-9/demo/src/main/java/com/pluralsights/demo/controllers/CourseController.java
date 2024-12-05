package com.pluralsights.demo.controllers;


import com.pluralsights.demo.models.Course;
import com.pluralsights.demo.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Course c = this.courseService.getCourseById(id);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course createdCourse = courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable int courseId, @PathVariable long studentId) {
        Course updatedCourse = courseService.addStudentToCourse(courseId, studentId);
        return ResponseEntity.ok(updatedCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id) {
        Course updated = courseService.updateCourse(course, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
        this.courseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
