package com.johnteacher.quickstart.controllers_services_repositories;

public class TestingNotes {
/*
Tests are always good, lol. What's to say when you make a change that the program still works.
 - regression testing ensures existing functionality continues to work as intended despite code changes
 - documentation for how your code should be used
 - helps code maintainability
 - tests provide a safety net for refactoring code
 - tests help make sure changes by one developer don't negatively impact others
 - in CI/CD (Continuous Integration or Continuous Deployment) tests are run automatically when new code is pushed
 - reduces debugging time
 - helps scalability and security as well

 Spring Boot provides utilities and annotations for testing.
 - It's supported by 2 modules
 - - spring-boot-test has core items
 - - spring-boot-test-autoconfigure supports autoconfig
 - - spring-boot-starter-test "Starter", imports:
 - - - Spring Boot test modules
 - - - JUnit, AssertJ, Hamcrest, and other useful libraries

 Provides annotations like
 - @SpringBootTest when you need Spring Boot features during test

When testing a student package (i.e. you want to test the service etc.), keep the same name! IDE also prefers this

Good things to test:
 - Mappers
 - Services

Notes:
 - Test isolation is ideal (i.e. test a class only on it's methods, not on it's dependencies
 - - Mockito is a popular Java Testing framework ("called mocking)
 */
}
