package com.example.array.warehouse;

import com.example.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    private static final Logger logger = LogManager.getLogger(ArrayWarehouse.class);
    private static ArrayWarehouse instance;
    private final Map<String, ArrayStatistics> storage = new HashMap<>();

    private ArrayWarehouse() {
    }

    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
        }
        return instance;
    }

    public void recalculate(CustomArray array) {
        int[] data = array.getData();
        int min = data[0];
        int max = data[0];
        long sum = 0;
        for (int value : data) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
            sum += value;
        }
        double average = (double) sum / data.length;
        ArrayStatistics stats = new ArrayStatistics(min, max, sum, average);
        storage.put(array.getId(), stats);
        logger.info("Warehouse updated for id {}: {}", array.getId(), stats);
    }

    public ArrayStatistics getStatistics(String id) {
        return storage.get(id);
    }

    public void remove(String id) {
        storage.remove(id);
        logger.info("Warehouse entry removed for id: {}", id);
    }
}