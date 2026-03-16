package com.example.array.factory;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.observer.WarehouseObserver;
import com.example.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactory implements ArrayFactory {

    private static final Logger logger = LogManager.getLogger(CustomArrayFactory.class);

    @Override
    public CustomArray createArray(int[] data) throws CustomArrayException {
        if (data == null) {
            logger.error("Attempt to create array with null data");
            throw new CustomArrayException("Array data cannot be null");
        }
        CustomArray array = new CustomArray(data);
        // Подписываем Warehouse как Observer сразу при создании
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        array.addObserver(new WarehouseObserver(warehouse));
        // Сразу считаем начальную статистику
        warehouse.recalculate(array);
        logger.info("Array created: {}", array);
        return array;
    }
}