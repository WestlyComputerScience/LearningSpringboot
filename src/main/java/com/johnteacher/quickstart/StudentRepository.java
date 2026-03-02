package com.johnteacher.quickstart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository is a generic interface
// <T, ID> with ID being the identity
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // use the "firstName" var, not the Column name!
    // any string I pass, it should be part of the firstName
    // FirstName in method call should match firstName in parameter
    // search the list of students with the first name containing a portion of the string that was passed
    List<Student> findAllByFirstNameContaining(String firstName);


}
