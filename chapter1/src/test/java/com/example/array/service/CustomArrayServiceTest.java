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
        // given
        CustomArray array = new CustomArray(SAMPLE_DATA);
        // when
        int result = service.findMin(array);
        // then
        assertEquals(EXPECTED_MIN, result);
    }

    @Test
    void testFindMax() throws CustomArrayException {
        // given
        CustomArray array = new CustomArray(SAMPLE_DATA);
        // when
        int result = service.findMax(array);
        // then
        assertEquals(EXPECTED_MAX, result);
    }

    @Test
    void testCalculateSum() throws CustomArrayException {
        // given
        CustomArray array = new CustomArray(SAMPLE_DATA);
        // when
        long result = service.calculateSum(array);
        // then
        assertEquals(EXPECTED_SUM, result);
    }

    @Test
    void testSortBubble() throws CustomArrayException {
        // given
        CustomArray array = new CustomArray(SAMPLE_DATA);
        // when
        CustomArray result = service.sortBubble(array);
        // then
        assertArrayEquals(SORTED_DATA, result.getData());
    }

    @Test
    void testSortSelection() throws CustomArrayException {
        // given
        CustomArray array = new CustomArray(SAMPLE_DATA);
        // when
        CustomArray result = service.sortSelection(array);
        // then
        assertArrayEquals(SORTED_DATA, result.getData());
    }

    @Test
    void testFindMinThrowsOnNull() {
        // given / when / then
        assertThrows(CustomArrayException.class, () -> service.findMin(null));
    }

    @Test
    void testFindMaxThrowsOnNull() {
        // given / when / then
        assertThrows(CustomArrayException.class, () -> service.findMax(null));
    }

    @Test
    void testFindMinThrowsOnEmpty() {
        // given
        CustomArray array = new CustomArray(new int[]{});
        // when / then
        assertThrows(CustomArrayException.class, () -> service.findMin(array));
    }
}