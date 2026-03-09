package com.johnteacher.quickstart;

// Allows us to hide the student ID etc. from the API accessing them. It only gives this information.
public record StudentDTO(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) { }
