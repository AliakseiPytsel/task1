package com.example.array.service;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayServiceTest {

    private static final CustomArrayService service = new CustomArrayService();

    private static final int[] SAMPLE_DATA = {5, 3, 8, 1, 9, 2};
    private static final int[] SORTED_DATA = {1, 2, 3, 5, 8, 9};
    private static final int EXPECTED_MIN = 1;
    private static final int EXPECTED_MAX = 9;
    private static final long EXPECTED_SUM = 28L;

    @Test
    void testFindMin() throws CustomArrayException {
        CustomArray array = new CustomArray(SAMPLE_DATA);
        int result = service.findMin(array);
        assertEquals(EXPECTED_MIN, result);
    }

    @Test
    void testFindMax() throws CustomArrayException {
        CustomArray array = new CustomArray(SAMPLE_DATA);
        int result = service.findMax(array);
        assertEquals(EXPECTED_MAX, result);
    }

    @Test
    void testCalculateSum() throws CustomArrayException {
        CustomArray array = new CustomArray(SAMPLE_DATA);
        long result = service.calculateSum(array);
        assertEquals(EXPECTED_SUM, result);
    }

    @Test
    void testSortBubble() throws CustomArrayException {
        CustomArray array = new CustomArray(SAMPLE_DATA);
        CustomArray result = service.sortBubble(array);
        assertArrayEquals(SORTED_DATA, result.getData());
    }

    @Test
    void testSortSelection() throws CustomArrayException {
        CustomArray array = new CustomArray(SAMPLE_DATA);
        CustomArray result = service.sortSelection(array);
        assertArrayEquals(SORTED_DATA, result.getData());
    }

    @Test
    void testFindMinThrowsOnNull() {
        assertThrows(CustomArrayException.class, () -> service.findMin(null));
    }

    @Test
    void testFindMaxThrowsOnNull() {
        assertThrows(CustomArrayException.class, () -> service.findMax(null));
    }

    @Test
    void testFindMinThrowsOnEmpty() {
        CustomArray array = new CustomArray(new int[]{});
        assertThrows(CustomArrayException.class, () -> service.findMin(array));
    }
}