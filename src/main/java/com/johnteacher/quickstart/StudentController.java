package com.johnteacher.quickstart;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper; // don't forget to inject these variables in constructor to provide access to their methods

    // injects the StudentRepository to access student table in the database
    public StudentController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll(); // returns all students in database
    }

    @PostMapping("/students")
    public StudentResponseDTO post(@RequestBody StudentDTO dto) { // StudentDTO since we want to not release sensitive information
        Student student = studentMapper.toStudent(dto);
        // return studentRepository.save(student); // student will be persisted (saved into a database)
        var savedStudent = studentRepository.save(student); // stored only necessary info (hides school ID)
        return studentMapper.toStudentResponseDTO(savedStudent); // now we return an even more secure response
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

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id) {
        studentRepository.deleteById(id); // deletes the specified student by ID
    }

}
