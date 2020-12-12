package com.example.springboot.database.permStorage;

import com.example.springboot.database.tempStorage.UsageData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
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

    @Query(value = "SELECT count(id) FROM temp_storage.task where closed = 0", nativeQuery = true)
    public int getOpenTimes();

    @Query(value = "SELECT count(id) FROM temp_storage.task where closed = 1", nativeQuery = true)
    public int getClosedTimes();

    @Query(value = "SELECT * FROM temp_storage.task where id = :taskid", nativeQuery = true)
    public List<Task> getTaskById(@Param("taskid") String taskid);

    @Query(value = "SELECT user.username, avg(idle_minutes+active_minutes), user.id FROM temp_storage.task \n" +
            "            left join temp_storage.user on temp_storage.user.id = temp_storage.task.user_id\n" +
            "            where task_type_id = :tasktypeid group by user_id order by user.id", nativeQuery = true)
    public List<Object[]> getTaskTimesForUsers(@Param("tasktypeid") int tasktypeid);

    @Query(value = "SELECT avg(idle_minutes+active_minutes) FROM temp_storage.task \n" +
            "            left join temp_storage.user on temp_storage.user.id = temp_storage.task.user_id\n" +
            "            where task_type_id = :tasktypeid and user.id=:userid group by user_id order by user.id", nativeQuery = true)
    public double getOpenTaskTimesForUser(@Param("tasktypeid") int tasktypeid, @Param("userid") int userid);

    @Query(value = "SELECT tt.id, tt.task_type_name FROM temp_storage.task t\n" +
            "left join temp_storage.task_type tt on t.task_type_id=tt.id\n" +
            "where user_id=:userid and closed=0", nativeQuery = true)
    public List<Object[]> getUsersCurrentTask(@Param("userid") int userid);

    @Query(value = "SELECT id, end_time FROM temp_storage.task where task_type_id=:taskType and user_id=:userId", nativeQuery = true)
    public ArrayList<Object[]> getTaskIDsWhere(@Param("taskType") int taskType, @Param("userId") int userId);

    @Query(value = "SELECT count(fe.id) FROM temp_storage.field_event fe\n" +
            "left join temp_storage.task t on fe.task_id = t.id\n" +
            "where start_time > :endDate and t.id = :taskType", nativeQuery = true)
    public int getModifications(@Param("taskType") String taskType, @Param("endDate") Date endDate);
}