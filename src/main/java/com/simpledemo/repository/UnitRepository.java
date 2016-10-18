package com.simpledemo.repository;

import com.simpledemo.domain.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UnitRepository extends CrudRepository<Unit, Long>{
    public ArrayList<Unit> findAll();
}
