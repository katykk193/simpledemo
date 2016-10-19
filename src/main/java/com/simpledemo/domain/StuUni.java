package com.simpledemo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="STUUNI")
public class StuUni implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;

    @Column(name="GRADE")
    private Double grade;

    @Column(name="assignment")
    private String assignment;

    public StuUni(){

    }

    public StuUni(Student student, Unit unit){
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
