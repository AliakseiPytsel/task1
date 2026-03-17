package com.example.array.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayValidatorTest {

    private static final CustomArrayValidator validator = new CustomArrayValidator();

    private static final String VALID_LINE_SEMICOLON = "1; 2; 3";
    private static final String VALID_LINE_SPACES = "3 4 7";
    private static final String VALID_LINE_DASHES = "1 - 2 - 3";
    private static final String INVALID_LINE_LETTERS = "1y1 21 32";
    private static final String INVALID_LINE_MIXED = "1; 2; x3; 6..5; 77";

    @Test
    void testValidLineSemicolon() {
        String line = VALID_LINE_SEMICOLON;
        boolean result = validator.isValidLine(line);
        assertTrue(result);
    }

    @Test
    void testValidLineSpaces() {
        String line = VALID_LINE_SPACES;
        boolean result = validator.isValidLine(line);
        assertTrue(result);
    }

    @Test
    void testValidLineDashes() {
        String line = VALID_LINE_DASHES;
        boolean result = validator.isValidLine(line);
        assertTrue(result);
    }

    @Test
    void testInvalidLineWithLetters() {
        String line = INVALID_LINE_LETTERS;
        boolean result = validator.isValidLine(line);
        assertFalse(result);
    }

    @Test
    void testInvalidLineMixed() {
        String line = INVALID_LINE_MIXED;
        boolean result = validator.isValidLine(line);
        assertFalse(result);
    }

    @Test
    void testNullLine() {
        String line = null;
        boolean result = validator.isValidLine(line);
        assertFalse(result);
    }

    @Test
    void testEmptyLine() {
        String line = "";
        boolean result = validator.isValidLine(line);
        assertFalse(result);
    }
}