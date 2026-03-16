package com.example.array.observer;

import com.example.array.entity.CustomArray;
import com.example.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseObserver implements ArrayObserver {

    private static final Logger logger = LogManager.getLogger(WarehouseObserver.class);

    private final ArrayWarehouse warehouse;

    public WarehouseObserver(ArrayWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void update(CustomArray array) {
        logger.info("Array changed, recalculating warehouse for id: {}", array.getId());
        warehouse.recalculate(array);
    }
}