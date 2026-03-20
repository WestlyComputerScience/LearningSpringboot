package com.johnteacher.quickstart.controllers_services_repositories.student;

import jakarta.validation.constraints.NotEmpty;

// Allows us to hide the student ID etc. from the API accessing them. It only gives this information.
// automatically generates setters and getters via a Java Record file
public record StudentDTO(
        // basically makes sure the annotated element isn't null or non-empty
        @NotEmpty(message = "Firstname should not be empty") // should be from jakarta.validation.constraints or something similar
        String firstName,
        @NotEmpty(message = "Lastname should not be empty") // message specifies the error in Postman more
        String lastName,
        String email,
        Integer schoolId
) { }
