package com.example.array.specification;

import com.example.array.entity.CustomArray;
import com.example.array.warehouse.ArrayStatistics;
import com.example.array.warehouse.ArrayWarehouse;

public class MaxGreaterThanSpecification implements ArraySpecification {

    private final int threshold;

    public MaxGreaterThanSpecification(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean isSatisfiedBy(CustomArray array) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        ArrayStatistics stats = warehouse.getStatistics(array.getId());
        if (stats == null) {
            return false;
        }
        return stats.getMax() > threshold;
    }
}