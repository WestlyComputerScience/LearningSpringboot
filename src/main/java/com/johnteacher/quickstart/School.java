package com.johnteacher.quickstart;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_SCHOOL")
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "school") // 1 school can exist in many student table rows
    @JsonManagedReference // Stops our infinite cycle. Tells JSON the parent is in charge of serializing the child, prevents the child from trying to serialize the parent.
    private List<Student> students;

    public School(String name) {
        this.name = name;
    }

    // Note: remember that you need an empty constructor for an Entity
    public School() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
