package com.example.array.specification;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.factory.CustomArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {

    private static final CustomArrayFactory factory = new CustomArrayFactory();

    @Test
    void testSumGreaterThanTrue() throws CustomArrayException {
        CustomArray array = factory.createArray(new int[]{10, 20, 30});
        SumGreaterThanSpecification spec = new SumGreaterThanSpecification(50);
        boolean result = spec.isSatisfiedBy(array);
        assertTrue(result);
    }

    @Test
    void testSumGreaterThanFalse() throws CustomArrayException {
        CustomArray array = factory.createArray(new int[]{1, 2, 3});
        SumGreaterThanSpecification spec = new SumGreaterThanSpecification(50);
        boolean result = spec.isSatisfiedBy(array);
        assertFalse(result);
    }

    @Test
    void testMaxGreaterThanTrue() throws CustomArrayException {
        CustomArray array = factory.createArray(new int[]{1, 2, 100});
        MaxGreaterThanSpecification spec = new MaxGreaterThanSpecification(50);
        boolean result = spec.isSatisfiedBy(array);
        assertTrue(result);
    }

    @Test
    void testAverageGreaterThanTrue() throws CustomArrayException {
        CustomArray array = factory.createArray(new int[]{10, 20, 30});
        AverageGreaterThanSpecification spec = new AverageGreaterThanSpecification(15.0);
        boolean result = spec.isSatisfiedBy(array);
        assertTrue(result);
    }
}