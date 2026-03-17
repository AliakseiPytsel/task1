package com.example.array.service;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayService implements ArrayService {
    private static final Logger logger = LogManager.getLogger(CustomArrayService.class);

    @Override
    public int findMin(CustomArray array) throws CustomArrayException {
        validateArray(array);
        int[] data = array.getData();
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        logger.info("Min value: {}", min);
        return min;
    }

    @Override
    public int findMax(CustomArray array) throws CustomArrayException {
        validateArray(array);
        int[] data = array.getData();
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        logger.info("Max value: {}", max);
        return max;
    }

    @Override
    public long calculateSum(CustomArray array) throws CustomArrayException {
        validateArray(array);
        int[] data = array.getData();
        long sum = 0;
        for (int value : data) {
            sum += value;
        }
        logger.info("Sum: {}", sum);
        return sum;
    }

    @Override
    public CustomArray sortBubble(CustomArray array) throws CustomArrayException {
        validateArray(array);
        int[] data = array.getData();
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        logger.info("Array sorted by bubble sort");
        return new CustomArray(data);
    }

    @Override
    public CustomArray sortSelection(CustomArray array) throws CustomArrayException {
        validateArray(array);
        int[] data = array.getData();
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
        logger.info("Array sorted by selection sort");
        return new CustomArray(data);
    }

    private void validateArray(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array cannot be null");
        }
        if (array.length() == 0) {
            throw new CustomArrayException("Array cannot be empty");
        }
    }
}