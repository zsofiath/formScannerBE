package com.example.springboot.database.permStorage;

import com.example.springboot.database.tempStorage.UsageData;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}