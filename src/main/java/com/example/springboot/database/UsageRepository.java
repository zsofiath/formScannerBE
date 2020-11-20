package com.example.springboot.database;

import com.example.springboot.database.tempStorage.UsageData;
import org.springframework.data.repository.CrudRepository;

public interface UsageRepository extends CrudRepository<UsageData, Integer> {

}
