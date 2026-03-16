package com.example.array.repository;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {

    void add(CustomArray array);

    void remove(String id) throws CustomArrayException;

    CustomArray findById(String id) throws CustomArrayException;

    List<CustomArray> findAll();

    List<CustomArray> findBySpecification(ArraySpecification specification);

    List<CustomArray> sortBy(Comparator<CustomArray> comparator);
}