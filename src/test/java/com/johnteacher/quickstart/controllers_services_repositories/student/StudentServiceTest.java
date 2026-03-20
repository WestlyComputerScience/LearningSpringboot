package com.johnteacher.quickstart.controllers_services_repositories.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

    // Services we want to test
    @InjectMocks // Mocking framework looks for @Mock that are compatible with this (i.e. when we make a student service, the mocking framework will look for 2 objects with the Mock Annotation)
    private StudentService studentService;

    // dependencies
    @Mock // tells test class and mockito framework we want to creat mock for these dependencies
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        // IDE recommendations here not really important

        // "Create all mocks and inject them where needed"
        MockitoAnnotations.openMocks(this); // inits all Mockito annotations in test class (i.e. @InjectMocks and @Mock)
    }

    @Test
    public void should_successfully_save_a_student() {
        // Given
        StudentDTO dto = new StudentDTO("John", "Doe", "123@gmail.com", 1);
        Student student = new Student("John", "Doe", "123@gmail.com", 20);
        Student savedStudent = new Student("John", "Doe", "123@gmail.com", 20);
        savedStudent.setId(1);

        // Mock Calls
        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student); // since we don't actually have the repository with exact data in test mode
        Mockito.when(studentRepository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentResponseDTO(savedStudent)).thenReturn(new StudentResponseDTO("John", "Doe", "123@gmail.com"));

        // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstName(), responseDTO.firstName());
        assertEquals(dto.lastName(), responseDTO.lastName());
        assertEquals(dto.email(), responseDTO.email());

        // We also want to make sure each method was called once!
        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDTO(savedStudent);
    }

    @Test
    public void should_successfully_find_all_students() {
        // Given
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("John", "Doe", "123@gmail.com", 20));
        // students.add(new Student("John2", "Doe", "123@gmail.com", 20));

        // Mock Calls
        Mockito.when(studentRepository.findAll()).thenReturn(students); // return the list
        Mockito.when(studentMapper.toStudentResponseDTO(any(Student.class))).thenReturn(new StudentResponseDTO("John", "Doe", "123@gmail.com"));

        // When
        List<StudentResponseDTO> responseDTOs = studentService.findAllStudents();

        // Then
        assertEquals(students.size(), responseDTOs.size());

        // Verify # of calls
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void should_find_student_by_id() {
        // Given
        Integer studentId = 1;
        Student student = new Student("John", "Doe", "123@gmail.com", 20);

        // Mock Calls
        // Note: option means it may contain null or non-null values
        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.toStudentResponseDTO(any(Student.class))).thenReturn(new StudentResponseDTO("John", "Doe", "123@gmail.com"));

        // When
        StudentResponseDTO dto = studentService.findStudentByID(studentId);

        // Then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());

        // Verify # of calls
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void finds_student_by_name() {
        // Given
        String studentName = "John";
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("John", "Doe", "123@gmail.com", 20));

        // Mock Calls
        Mockito.when(studentRepository.findAllByFirstNameContaining(studentName)).thenReturn(students); // return the list
        Mockito.when(studentMapper.toStudentResponseDTO(any(Student.class))).thenReturn(new StudentResponseDTO("John", "Doe", "123@gmail.com"));

        // When
        var responseDto = studentService.findStudentByName(studentName);

        // Then
        assertEquals(students.size(), responseDto.size());

        // Verify # of calls
        verify(studentRepository, times(1)).findAllByFirstNameContaining(studentName);
    }

    @Test
    public void should_delete() {
        Integer studentId = 1;
        
    }
}