package com.simpledemo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
@DiscriminatorValue("S")
public class Student extends User{

    @Column(name="program")
    private String program;

    public Student(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setType("ROLE_STUDENT");
        this.setEnabled(1);
    }

}


/*
@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="PROGRAM")
    private String program;

    @Column(name="EMAIL")
    private String email;

//    @JoinTable(
//            name="STUUNI",
//            joinColumns = {@JoinColumn(name="STUDENT_ID", referencedColumnName="STUDENT_ID")},
//            inverseJoinColumns = {@JoinColumn(name="UNIT_ID", referencedColumnName="ID", unique=true)}
//    )
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StuUni> stuunis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<StuUni> getStuunis() {
        return stuunis;
    }

    public void setStuunis(Set<StuUni> stuunis) {
        this.stuunis = stuunis;
    }
}
*/