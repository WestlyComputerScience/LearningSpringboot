package com.johnteacher.quickstart;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecondController {

    private final StudentRepository studentRepository;

    // injects the StudentRepository to access student table in the database
    public SecondController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll(); // returns all students in database
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return studentRepository.save(student); // student will be persisted (saved into a database)
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentByID(@PathVariable("student-id") Integer studentId) {
        // note we call student repository to search our database
        // otherwise returns empty student object
        // all comes from the Jpa extended class
        return studentRepository.findById(studentId).orElse(null); // return null if it can't be found
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String studentName) {
        return studentRepository.findAllByFirstNameContaining(studentName);
    }

}
