package com.simpledemo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UnitRepository extends CrudRepository<Unit, Long>{
    public ArrayList<Unit> findAll();
}
