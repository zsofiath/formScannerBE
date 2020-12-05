package com.example.springboot.database;

import com.example.springboot.database.tempStorage.UsageData;
import javafx.util.Pair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UsageRepository extends CrudRepository<UsageData, Integer> {
    @Query(value = "SELECT task_id, MIN(timestamp) as min, MAX(timestamp) as max, task_type, username FROM temp_storage.usage_data GROUP BY task_id, task_type, username", nativeQuery = true)
    public List<Object[]> getStartEndAndTime();

    @Query(value = "SELECT * FROM temp_storage.usage_data where task_id = :taskid AND event in('visible', 'onfocus','idle','onblur')", nativeQuery = true)
    public List<UsageData> getTaskActions(@Param("taskid") String taskid);

    @Query(value = "SELECT task_type, element FROM temp_storage.usage_data where task_id = :taskid AND event in('click', 'blur', 'change', 'keyup', 'Empty', 'Backspace', 'Delete', 'Typing') group by task_type, element", nativeQuery = true)
    public List<Object[]> getTaskActions_inputEvents(@Param("taskid") String taskid);
}
