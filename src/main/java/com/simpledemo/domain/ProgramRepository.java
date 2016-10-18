package com.simpledemo.domain;


import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProgramRepository extends CrudRepository<Program, Long> {

    public ArrayList<Program> findAll();

}
