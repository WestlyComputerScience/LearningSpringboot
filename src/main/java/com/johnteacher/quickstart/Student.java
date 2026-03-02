package com.johnteacher.quickstart;

import jakarta.persistence.*;

// Note: based on uniqueness and insertion information, be careful with duplicate data!

// basically makes it able to turn into a table in PostgreSQL
@Entity
@Table(name = "T_STUDENT") // default value is Student class or Entity name
public class Student {

    @Id // makes it the identifier for the table
    @GeneratedValue // only for primary keys. Automatically generates primary keys for us.
    // Integer class for our interface
    private Integer id;

    // length specifies the max length of the string
    @Column(name = "c_fname", length = 20) // defaults to field name property
    private String firstName;
    private String lastName;

    // if unique = true, then we can't have duplicates
    // gives us a primary key
    @Column(unique = true)
    private String email;
    private int age;
    // insertable false makes sure we can't insert a value into this field
    @Column(updatable = false, insertable = false) // don't want the creation date to be updateable
    private String creation_date;

    // ID shouldn't be in constructor since it's automatically generated. creation_date as well since it's not insertable
    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
