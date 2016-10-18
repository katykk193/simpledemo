package com.simpledemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAM")
public class Program {

    @Id
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="TOTALCREDIT")
    private int totalCredit;

    @Column(name="ENROLEACHSEM")
    private int enrolEachSem;

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

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public int getEnrolEachSem() {
        return enrolEachSem;
    }

    public void setEnrolEachSem(int enrolEachSem) {
        this.enrolEachSem = enrolEachSem;
    }

}
