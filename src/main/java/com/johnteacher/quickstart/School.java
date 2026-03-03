package com.johnteacher.quickstart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_SCHOOL")
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

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
}
