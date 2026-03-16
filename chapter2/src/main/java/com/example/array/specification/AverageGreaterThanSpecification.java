package com.example.array.specification;

import com.example.array.entity.CustomArray;
import com.example.array.warehouse.ArrayStatistics;
import com.example.array.warehouse.ArrayWarehouse;

public class AverageGreaterThanSpecification implements ArraySpecification {

    private final double threshold;

    public AverageGreaterThanSpecification(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean isSatisfiedBy(CustomArray array) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        ArrayStatistics stats = warehouse.getStatistics(array.getId());
        if (stats == null) {
            return false;
        }
        return stats.getAverage() > threshold;
    }
}