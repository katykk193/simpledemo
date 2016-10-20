package com.simpledemo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="STUUNIT")
public class StuUnit implements Serializable {

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private Student student;

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;

    @Column(name="ASSIGNMENT")
    private String assignment;

    @Column(name="GRADE")
    private Double grade;

    public StuUnit(){

    }

    public StuUnit(Student student, Unit unit){
        this.student = student;
        this.unit = unit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
