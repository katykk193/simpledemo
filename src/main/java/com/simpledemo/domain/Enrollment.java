package com.simpledemo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Enrollment")
public class Enrollment {

    @Id
    private long id;

    @Column(name="studentID")
    private long studentID;

    @Column(name="UnitID")
    private long unitID;

    @Column(name="PROGRAM")
    private String program;

    @Column(name="unitName")
    private String unitName;


    public Enrollment() {
    }

    public Enrollment(long id,long studentID, long unitID,String unitName){
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

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
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
