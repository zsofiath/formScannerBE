package com.example.springboot.database;

import org.springframework.data.repository.CrudRepository;

public interface UsageRepository extends CrudRepository<UsageData, Integer> {

}
