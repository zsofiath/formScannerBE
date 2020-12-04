package com.example.springboot.transformation;

import com.example.springboot.database.UsageRepository;
import com.example.springboot.database.tempStorage.UsageData;

import java.util.List;
import java.util.Optional;

public class TestUsageRepo implements UsageRepository {
    @Override
    public List<Object[]> getStartEndAndTime() {
        return null;
    }

    @Override
    public List<UsageData> getTaskActions(String taskid) {
        return null;
    }

    @Override
    public <S extends UsageData> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UsageData> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UsageData> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<UsageData> findAll() {
        return null;
    }

    @Override
    public Iterable<UsageData> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(UsageData entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsageData> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
