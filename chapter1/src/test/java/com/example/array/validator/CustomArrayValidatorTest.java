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
        // given
        String line = VALID_LINE_SEMICOLON;
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertTrue(result);
    }

    @Test
    void testValidLineSpaces() {
        // given
        String line = VALID_LINE_SPACES;
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertTrue(result);
    }

    @Test
    void testValidLineDashes() {
        // given
        String line = VALID_LINE_DASHES;
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertTrue(result);
    }

    @Test
    void testInvalidLineWithLetters() {
        // given
        String line = INVALID_LINE_LETTERS;
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertFalse(result);
    }

    @Test
    void testInvalidLineMixed() {
        // given
        String line = INVALID_LINE_MIXED;
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertFalse(result);
    }

    @Test
    void testNullLine() {
        // given
        String line = null;
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertFalse(result);
    }

    @Test
    void testEmptyLine() {
        // given
        String line = "";
        // when
        boolean result = validator.isValidLine(line);
        // then
        assertFalse(result);
    }
}