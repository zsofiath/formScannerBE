package com.example.springboot.database.permStorage;

import com.example.springboot.database.tempStorage.UsageData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    @Query(value = "SELECT task_type_name, avg(idle_minutes+active_minutes) tim, \n" +
            "avg(idle_minutes) idle,\n" +
            "avg(active_minutes) act\n" +
            "FROM temp_storage.task\n" +
            "left join temp_storage.task_type on temp_storage.task_type.id = temp_storage.task.task_type_id\n" +
            "group by task_type_id;", nativeQuery = true)
    public List<String[]> getTaskTimes(@Param("taskid") String taskid);

    @Query(value = "SELECT avg(idle_minutes) idl, avg(active_minutes) act FROM temp_storage.task", nativeQuery = true)
    public List<String[]> getIdleActive(@Param("taskid") String taskid);
}