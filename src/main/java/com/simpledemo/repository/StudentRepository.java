package com.simpledemo.repository;

import com.simpledemo.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    public Student findOne(long id);

}