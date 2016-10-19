package com.simpledemo.repository;


import com.simpledemo.domain.Program;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProgramRepository extends CrudRepository<Program, Long> {

}
