package com.johnteacher.quickstart.controllers_services_repositories.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper; // don't forget to inject these variables in constructor to provide access to their methods

    // injects the StudentRepository to access student table in the database
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponseDTO> findAllStudents() {
        // this.studentRepository.findAll() = returns a List<Student> containing all students from database
        // .stream() = converts the list to a stream to apply functions like map, filter, forEach, etc.
        // .map(studentMapper::toStudentResponseDTO) = map transforms each element of the stream,
        //                                             the :: part is a method reference that takes a
        //                                             Student object and converts it into a StudentResponseDTO
        // .collect(Collectors.toList()) = after mapping, stream needs to be converted back to a list
        return this.studentRepository.findAll().stream().map(studentMapper::toStudentResponseDTO).collect(Collectors.toList());  // returns all students in database
    }

    public StudentResponseDTO saveStudent(StudentDTO dto) {
        Student student = studentMapper.toStudent(dto);
        // return studentRepository.save(student); // student will be persisted (saved into a database)
        var savedStudent = studentRepository.save(student); // stored only necessary info (hides school ID)
        return studentMapper.toStudentResponseDTO(savedStudent); // now we return an even more secure response
    }

    public StudentResponseDTO findStudentByID(Integer studentId) {
        // note we call student repository to search our database
        // otherwise returns empty student object
        // all comes from the Jpa extended class
        return studentRepository.findById(studentId).map(studentMapper::toStudentResponseDTO).orElse(null); // return null if it can't be found
    }

    public List<StudentResponseDTO> findStudentByName(String studentName) {
        return studentRepository.findAllByFirstNameContaining(studentName).stream().map(studentMapper::toStudentResponseDTO).collect(Collectors.toList());
    }

    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

}
