package com.example.springboot.database.permStorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FieldRepository extends CrudRepository<Field, Integer> {
    @Query(value = "SELECT * FROM temp_storage.field where field_name = :name and task_type_id = :taskType", nativeQuery = true)
    public Field findBy(@Param("name") String name, @Param("taskType") int taskType);

    @Query(value = "SELECT field_name, count(temp_storage.field_event.id) FROM temp_storage.field_event \n" +
            "left join temp_storage.field on temp_storage.field.id = temp_storage.field_event.field_id\n" +
            "where  temp_storage.field.task_type_id = :tasktype\n" +
            "group by field_id;", nativeQuery = true)
    public List<String[]> getFields(@Param("tasktype") int tasktype);
}

