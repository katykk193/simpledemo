package com.simpledemo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Enrollment")
public class Enrollment {

    @Id
    private long id;

    @Column(name="studentID")
    private String studentID;

    @Column(name="UnitID")
    private long unitID;

    @Column(name="PROGRAM")
    private String program;

    @Column(name="unitName")
    private String unitName;


    public Enrollment() {
    }

    public Enrollment(long id,String studentID, long unitID,String unitName){
        this.id=id;
        this.studentID = studentID;
        this.unitID = unitID;
        this.unitName=unitName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public long getUnitID() {
        return unitID;
    }

    public void setUnitID(long unitID) {
        this.unitID = unitID;
    }

    public String getProgram() {
        return program;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setProgram(String program) {
        this.program = program;
    }

}
