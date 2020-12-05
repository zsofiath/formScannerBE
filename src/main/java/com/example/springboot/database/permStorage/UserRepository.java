package com.example.springboot.database.permStorage;

import com.example.springboot.database.tempStorage.UsageData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM temp_storage.user where username = :name ", nativeQuery = true)
    public User findByName(@Param("name") String name);
}
