package com.simpledemo.repository;

import com.simpledemo.domain.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Set;

public interface UnitRepository extends CrudRepository<Unit, Long>{
    public Set<Unit> findByProgram(String program);

}
