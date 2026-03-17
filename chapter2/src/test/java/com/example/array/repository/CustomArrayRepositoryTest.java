package com.example.array.repository;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.factory.CustomArrayFactory;
import com.example.array.specification.SumGreaterThanSpecification;
import com.example.array.comparator.ArrayComparators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryTest {

    private CustomArrayRepository repository;
    private CustomArrayFactory factory;

    @BeforeEach
    void setUp() {
        repository = CustomArrayRepository.getInstance();
        factory = new CustomArrayFactory();
        for (CustomArray array : repository.findAll()) {
            try {
                repository.remove(array.getId());
            } catch (CustomArrayException e) {
            }
        }
    }

    @Test
    void testAddAndFindById() throws CustomArrayException {
        CustomArray array = new CustomArray(new int[]{1, 2, 3});
        repository.add(array);
        CustomArray found = repository.findById(array.getId());
        assertEquals(array.getId(), found.getId());
    }

    @Test
    void testRemove() throws CustomArrayException {
        CustomArray array = new CustomArray(new int[]{1, 2, 3});
        repository.add(array);
        repository.remove(array.getId());
        assertThrows(CustomArrayException.class, () -> repository.findById(array.getId()));
    }

    @Test
    void testFindBySpecification() throws CustomArrayException {
        CustomArray small = factory.createArray(new int[]{1, 2, 3});
        CustomArray large = factory.createArray(new int[]{10, 20, 30});
        repository.add(small);
        repository.add(large);
        List<CustomArray> result = repository.findBySpecification(
                new SumGreaterThanSpecification(20)
        );
        assertEquals(1, result.size());
        assertEquals(large.getId(), result.get(0).getId());
    }

    @Test
    void testSortByLength() throws CustomArrayException {
        CustomArray short1 = factory.createArray(new int[]{1, 2});
        CustomArray long1 = factory.createArray(new int[]{1, 2, 3, 4, 5});
        CustomArray medium = factory.createArray(new int[]{1, 2, 3});
        repository.add(long1);
        repository.add(short1);
        repository.add(medium);
        List<CustomArray> sorted = repository.sortBy(ArrayComparators.byLength());
        assertEquals(2, sorted.get(0).length());
        assertEquals(3, sorted.get(1).length());
        assertEquals(5, sorted.get(2).length());
    }

    @Test
    void testFindByIdThrowsWhenNotFound() {
        assertThrows(CustomArrayException.class, () -> repository.findById("non-existent-id"));
    }
}