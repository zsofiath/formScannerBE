package com.example.springboot.database.permStorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FieldRepository extends CrudRepository<Field, Integer> {
    @Query(value = "SELECT * FROM temp_storage.field where field_name = :name and task_type_id = :taskType", nativeQuery = true)
    public Field findBy(@Param("name") String name, @Param("taskType") int taskType);
}

