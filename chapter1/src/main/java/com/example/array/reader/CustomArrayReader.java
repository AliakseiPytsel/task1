package com.example.array.reader;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;
import com.example.array.factory.ArrayFactory;
import com.example.array.factory.CustomArrayFactory;
import com.example.array.validator.ArrayValidator;
import com.example.array.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomArrayReader implements ArrayReader {
    private static final Logger logger = LogManager.getLogger(CustomArrayReader.class);
    private static final String DELIMITER_REGEX = "[;,\\-\\s]+";

    private final ArrayValidator validator = new CustomArrayValidator();
    private final ArrayFactory factory = new CustomArrayFactory();

    @Override
    public List<CustomArray> readArraysFromFile(String filePath) throws CustomArrayException {
        List<String> lines = readLines(filePath);
        List<CustomArray> arrays = new ArrayList<>();
        for (String line : lines) {
            boolean isValid = validator.isValidLine(line);
            if (isValid) {
                CustomArray array = parseLine(line);
                arrays.add(array);
            }
        }
        logger.info("Total valid arrays read: {}", arrays.size());
        return arrays;
    }

    private List<String> readLines(String filePath) throws CustomArrayException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            logger.info("File read successfully: {}", filePath);
            return lines;
        } catch (IOException e) {
            logger.error("Failed to read file: {}", filePath);
            throw new CustomArrayException("Failed to read file: " + filePath, e);
        }
    }

    private CustomArray parseLine(String line) throws CustomArrayException {
        String[] parts = line.trim().split(DELIMITER_REGEX);
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                numbers.add(Integer.parseInt(trimmed));
            }
        }
        int[] data = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            data[i] = numbers.get(i);
        }
        return factory.createArray(data);
    }
}