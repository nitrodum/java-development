package com.pluralsights.demo.services;

import com.pluralsights.demo.models.Student;
import com.pluralsights.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository ) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        Student s = new Student();
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setAge(student.getAge());
        return this.studentRepository.save(s);
    }

    public Student updateStudent(long id, Student student) {
        Student s = getStudentById(id);
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setAge(student.getAge());
        return this.studentRepository.save(s);
    }

    public void delete(long id) {
        this.studentRepository.deleteById(id);
    }
}
