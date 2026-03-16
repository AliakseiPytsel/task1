package com.example.array.warehouse;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.factory.CustomArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayWarehouseTest {

    private static final CustomArrayFactory factory = new CustomArrayFactory();
    private static final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

    @Test
    void testWarehouseCalculatesStatsOnCreate() throws CustomArrayException {
        // given
        CustomArray array = factory.createArray(new int[]{1, 2, 3, 4, 5});
        // when
        ArrayStatistics stats = warehouse.getStatistics(array.getId());
        // then
        assertEquals(1, stats.getMin());
        assertEquals(5, stats.getMax());
        assertEquals(15L, stats.getSum());
        assertEquals(3.0, stats.getAverage());
    }

    @Test
    void testWarehouseUpdatesOnElementChange() throws CustomArrayException {
        // given
        CustomArray array = factory.createArray(new int[]{1, 2, 3});
        // when
        array.setElement(0, 100);
        ArrayStatistics stats = warehouse.getStatistics(array.getId());
        // then
        assertEquals(100, stats.getMax());
        assertEquals(105L, stats.getSum());
    }

    @Test
    void testWarehouseUpdatesOnSetData() throws CustomArrayException {
        // given
        CustomArray array = factory.createArray(new int[]{1, 2, 3});
        // when
        array.setData(new int[]{10, 20, 30});
        ArrayStatistics stats = warehouse.getStatistics(array.getId());
        // then
        assertEquals(10, stats.getMin());
        assertEquals(30, stats.getMax());
        assertEquals(60L, stats.getSum());
    }
}