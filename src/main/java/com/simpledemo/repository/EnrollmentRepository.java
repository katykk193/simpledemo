package com.simpledemo.repository;

import com.simpledemo.domain.Enrollment;
import com.simpledemo.domain.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long>{
    public ArrayList<Enrollment> findAll();
    //public ArrayList<Enrollment> findbyID(long id);
}
