package com.johnteacher.quickstart.controllers_services_repositories.student;

import jakarta.validation.Valid;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    // the @Valid makes sure the studentDTO has validation applied to it
    public StudentResponseDTO saveStudent(@Valid @RequestBody StudentDTO dto) { // StudentDTO since we want to not release sensitive information
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

    @ExceptionHandler(MethodArgumentNotValidException.class) // taks a list or single value classes. In our case, we want to through an exception for this specific case only
    // "<?>" = means of any type, so for us it means a Response Entity of any type
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors(). // returns a list of object errors
                            // this is a lambda expression
                            forEach(error -> { // errors coming from our annotations (i.e. in DTO class annotation like @NotEmpty())
                                var fieldName = ((FieldError) error).getField(); // cast it to a FieldError to use the getField() method
                                var errorMessage = error.getDefaultMessage(); // gets default error message through by exception
                                errors.put(fieldName, errorMessage); // formed an object to give to our customer
                            });
        // lol, in postman, we now see "lastname": "must not be empty
        // fieldname for the var name
        // error message for the reasoning why
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // Now, everytime not valid exception is raise,
                                                                     // this method intercepts it, and transforms it
                                                                     // into a proper response to send to the user
    }

}
