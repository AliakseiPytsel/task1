package com.example.array.repository;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.specification.ArraySpecification;
import com.example.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepository implements ArrayRepository {
    private static final Logger logger = LogManager.getLogger(CustomArrayRepository.class);
    private static CustomArrayRepository instance;
    private final List<CustomArray> arrays = new ArrayList<>();

    private CustomArrayRepository() {
    }

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    @Override
    public void add(CustomArray array) {
        arrays.add(array);
        logger.info("Array added to repository: {}", array.getId());
    }

    @Override
    public void remove(String id) throws CustomArrayException {
        CustomArray found = findById(id);
        arrays.remove(found);
        ArrayWarehouse.getInstance().remove(id);
        logger.info("Array removed from repository: {}", id);
    }

    @Override
    public CustomArray findById(String id) throws CustomArrayException {
        for (CustomArray array : arrays) {
            if (array.getId().equals(id)) {
                return array;
            }
        }
        throw new CustomArrayException("Array not found with id: " + id);
    }

    @Override
    public List<CustomArray> findAll() {
        return new ArrayList<>(arrays);
    }

    @Override
    public List<CustomArray> findBySpecification(ArraySpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        for (CustomArray array : arrays) {
            if (specification.isSatisfiedBy(array)) {
                result.add(array);
            }
        }
        return result;
    }

    @Override
    public List<CustomArray> sortBy(Comparator<CustomArray> comparator) {
        List<CustomArray> sorted = new ArrayList<>(arrays);
        sorted.sort(comparator);
        return sorted;
    }
}