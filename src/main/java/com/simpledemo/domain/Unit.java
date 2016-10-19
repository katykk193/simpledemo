package com.simpledemo.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="unit")
public class Unit {

    @Id
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="lecturer")
    private String lecturer;

    @Column(name="program")
    private String program;

    @Column(name="credit")
    private int credit;

    @Column(name="description")
    private String description;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="STUUNI",
//            joinColumns = {@JoinColumn(name="id")},
//            inverseJoinColumns = {@JoinColumn(name="unit_id")})
//    private ArrayList<Student> students = new ArrayList<Student>();

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

//    public ArrayList<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(ArrayList<Student> students) {
//        this.students = students;
//    }
}
