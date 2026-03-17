package com.example.array.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayValidator implements ArrayValidator {
    private static final Logger logger = LogManager.getLogger(CustomArrayValidator.class);
    private static final String VALID_LINE_REGEX = "^[\\d\\s;,\\-]+$";

    @Override
    public boolean isValidLine(String line) {
        if (line == null || line.strip().isBlank()) {
            logger.warn("Line is null or empty");
            return false;
        }
        boolean isValid = line.strip().matches(VALID_LINE_REGEX);
        if (isValid) {
            logger.info("Line is valid: {}", line);
        } else {
            logger.warn("Line is invalid: {}", line);
        }
        return isValid;
    }
}