package com.johnteacher.quickstart;

import jakarta.persistence.*;

@Entity
@Table(name = "T_PROFILE")
public class Profile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    @OneToOne
    // when we start the application, we'll have an extra field in Profile Table having the name student_id
    // can't be id, since that's the same as the id variable in Student, so name it student_id
    @JoinColumn(name = "student_id") // we want a join column
    private Student student; // name should be the same as mappedBy = "student"

    public Profile() {}

    public Profile(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
