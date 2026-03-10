package com.johnteacher.quickstart;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> findAllStudents() {
        return this.studentService.findAllStudents();  // returns all students in database
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@RequestBody StudentDTO dto) { // StudentDTO since we want to not release sensitive information
        return this.studentService.saveStudent(dto); // uses our service for the method
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO findStudentByID(@PathVariable("student-id") Integer studentId) {
        return this.studentService.findStudentByID(studentId);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDTO> findStudentByName(@PathVariable("student-name") String studentName) {
        return this.studentService.findStudentByName(studentName);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id) {
        this.studentService.delete(id);
    }

}
