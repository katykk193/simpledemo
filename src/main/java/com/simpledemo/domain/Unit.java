package com.simpledemo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="UNIT")
public class Unit {

    @Id
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="LECTURER")
    private String lecturer;

    @Column(name="PROGRAM")
    private String program;

    @Column(name="CREDIT")
    private int credit;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
//    @JoinTable(
//            name="STUUNI",
//            joinColumns = {@JoinColumn(name="UNIT_ID", referencedColumnName="UNIT_ID")},
//            inverseJoinColumns = {@JoinColumn(name="STUDENT_ID", referencedColumnName="ID", unique=true)}
//    )
    private Set<StuUni> stuuni;

    public Unit() {
    }

    public Unit(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Unit(long id, String name, String lecturer, String program, int credit, String description){
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.program = program;
        this.credit = credit;
        this.description = description;
    }

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

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StuUni> getStuuni() {
        return stuuni;
    }

    public void setStuuni(Set<StuUni> stuuni) {
        this.stuuni = stuuni;
    }
}
