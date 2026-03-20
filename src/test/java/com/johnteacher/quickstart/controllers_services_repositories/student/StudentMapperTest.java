package com.johnteacher.quickstart.controllers_services_repositories.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    /* intro
    @BeforeAll
    static void beforeAll() { // this runs before all the methods (setup/teardown run before/after each test)
        System.out.println("This runs before all the methods");
    }

    @AfterAll
    static void afterAll() { // this runs after all test methods and after each's have run
        System.out.println("This runs after all the methods");
    }

    @BeforeEach // this setup method will execute before each test method
    void setUp() {
        System.out.println("Before each method.");
    }

    @AfterEach
    void tearDown() { // this will execute after all the test methods
        System.out.println("After each method.");
        System.out.println();
    }

    @Test
    public void testMethod1() {
        System.out.println("My first test method.");
    }

    @Test
    public void testMethod2() {
        System.out.println("My second test method.");
    }
     */

    private StudentMapper mapper; // declare the service you want to test

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDTO dto = new StudentDTO("John", "Doe", "john@email.com", 1);
        Student student = mapper.toStudent(dto); // map the dto to a student

        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());

        Assertions.assertNotNull(student.getSchool()); // make sure the school isn't null
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldStudentToStudentDto() {
        // Given
        Student student = new Student("Wes", "Goat", "something123@email.com", 4000);

        // When
        StudentResponseDTO dto = mapper.toStudentResponseDTO(student);

        // Then
        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());
    }

    // Check what happens in the case of a null value
    @Test
    public void should_throw_null_pointer_exception_when_studentDTO_is_null() {
        // basically says we should get this exception when calling this mapper function
        var exp = Assertions.assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        Assertions.assertEquals("This student DTO should not be null", exp.getMessage()); // check if the error messages match
    }

}