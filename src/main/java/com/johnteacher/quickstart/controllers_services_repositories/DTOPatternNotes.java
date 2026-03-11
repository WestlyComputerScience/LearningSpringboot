package com.johnteacher.quickstart.controllers_services_repositories;

public class DTOPatternNotes {

/*
=== DTO ===
DTO = Data Transfer Object
    - main purpose is to encapsulate and structure data that needs to be transferred between
      different parts of a system or a different system entirely.
    - Usually only includes simple data fields/attributes and lacks the behavior of
      the model or entity it represents
    - Helps show non-sensitive information and keep sensitive information safe
    - - Done with Data Separation, can change internal model without affecting external representation
    - - also helps not expose sensitive information to API customers
    - provide an abstraction layer with a clear structure of what the API will provide to the client
    - Boost performance by only sending DTOs instead of entities (ability to control size of what you're sending)
    - Since they're separate from your domain module, they allow you to tailor your API
      response to exactly what you're client needs, even if it doesn't match your domain model.
    - DTOs make it easier to maintain versions of API by using different sets of
      DTOs to support multiple versions of API simultaneously
 */
/*
Introducing services (helps code reusability and separates concerns)
 - called the service layer
 - - plays a crucial role in handling business logic and application specific operations
     from the presentation layer (controller) and the data access layer (repository)
 - services good for maintaining a separation of concerns
 - - controller handles HTTP requests
 - - repositories handle data persistence and retrieval
 - - services sit between the two, ensuring business logic and application specific operations are separate from other layers
 */

/*
The next part of the course is validating the data (i.e. no invalid data like null values for a person's ID)
 - malicious users can spam send attacks to flood database with invalid data (we need to prevent this)
 - Can cause errors when you might recieve a number instead of a string
 - Greatly improve user experience, let's them know they did something wrong and why
 - Validation can help performance against poorly/incorrectly formatted data

 */

}
