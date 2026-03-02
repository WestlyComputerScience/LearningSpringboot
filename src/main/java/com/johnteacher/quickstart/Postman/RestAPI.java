package com.johnteacher.quickstart.Postman;

public class RestAPI {

/*
He used Postman to help manage REST APIs and test them as opposed to only GET requests from the browser
 - good way to test HTTP request methods like GET PUT, etc.
 */

/*
Entity: refers to a java object meant to be in a database (aka java persistence API)
 - each instance of an entity represents a row in a table

Also, good to use @Table for the table name with @Entity

Spring provides an interface called repository.
 - extended by many interfaces
 - - crud repositories and paging repositories
 - - Jpa (Java Persistence API, maps Java Classes (entities) to database tables)
     repository extends all these interfaces
 - - - Gives us things like CRUD (Create, Read, Update, Delete), which inherits from crud repositories
 - - - - allows basic database operations
 - - - Gives us query methods (i.e. we want a method to find by firstname or age,
                                put them as a parameter, and it can be implemented without writing queries)
 - - - Also gives us the creation of complex queries using derative query methods
 - - - Jpa really helps with less boilerplate code to get our database records and alter them

 */
}
