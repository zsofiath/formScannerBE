package com.example.springboot.database.permStorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TaskTypeRepository extends CrudRepository<TaskType, Integer> {
    @Query(value = "SELECT * FROM temp_storage.task_type where task_type_name = :name ", nativeQuery = true)
    public TaskType findByName(@Param("name") String name);
}
