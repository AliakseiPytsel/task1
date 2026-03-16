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
        // Сбрасываем синглтон перед каждым тестом через рефлексию не нужно —
        // просто используем новый экземпляр через getInstance и очищаем вручную
        repository = CustomArrayRepository.getInstance();
        factory = new CustomArrayFactory();
        // Очищаем репозиторий перед каждым тестом
        for (CustomArray array : repository.findAll()) {
            try {
                repository.remove(array.getId());
            } catch (CustomArrayException e) {
                // ignore
            }
        }
    }

    @Test
    void testAddAndFindById() throws CustomArrayException {
        // given
        CustomArray array = new CustomArray(new int[]{1, 2, 3});
        // when
        repository.add(array);
        CustomArray found = repository.findById(array.getId());
        // then
        assertEquals(array.getId(), found.getId());
    }

    @Test
    void testRemove() throws CustomArrayException {
        // given
        CustomArray array = new CustomArray(new int[]{1, 2, 3});
        repository.add(array);
        // when
        repository.remove(array.getId());
        // then
        assertThrows(CustomArrayException.class, () -> repository.findById(array.getId()));
    }

    @Test
    void testFindBySpecification() throws CustomArrayException {
        // given
        CustomArray small = factory.createArray(new int[]{1, 2, 3});
        CustomArray large = factory.createArray(new int[]{10, 20, 30});
        repository.add(small);
        repository.add(large);
        // when
        List<CustomArray> result = repository.findBySpecification(
                new SumGreaterThanSpecification(20)
        );
        // then
        assertEquals(1, result.size());
        assertEquals(large.getId(), result.get(0).getId());
    }

    @Test
    void testSortByLength() throws CustomArrayException {
        // given
        CustomArray short1 = factory.createArray(new int[]{1, 2});
        CustomArray long1 = factory.createArray(new int[]{1, 2, 3, 4, 5});
        CustomArray medium = factory.createArray(new int[]{1, 2, 3});
        repository.add(long1);
        repository.add(short1);
        repository.add(medium);
        // when
        List<CustomArray> sorted = repository.sortBy(ArrayComparators.byLength());
        // then
        assertEquals(2, sorted.get(0).length());
        assertEquals(3, sorted.get(1).length());
        assertEquals(5, sorted.get(2).length());
    }

    @Test
    void testFindByIdThrowsWhenNotFound() {
        // given / when / then
        assertThrows(CustomArrayException.class, () -> repository.findById("non-existent-id"));
    }
}