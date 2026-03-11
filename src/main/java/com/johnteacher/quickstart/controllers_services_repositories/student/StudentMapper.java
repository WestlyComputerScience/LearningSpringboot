package com.johnteacher.quickstart.controllers_services_repositories.student;

import com.johnteacher.quickstart.controllers_services_repositories.school.School;
import org.springframework.stereotype.Service;

// this service is responsible for mapping or creating mapping for our students
// aka handles our DTO's for us, reduces code in student controller
@Service
public class StudentMapper {

    public Student toStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.firstName());
        student.setLastName(studentDTO.lastName());
        student.setEmail(studentDTO.email());

        // need to get the school ID
        School school = new School();
        school.setId(studentDTO.schoolId()); // gets the school from the student's ID

        student.setSchool(school); // sets that student's school to the school object
        return student;
    }

    public StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

}
