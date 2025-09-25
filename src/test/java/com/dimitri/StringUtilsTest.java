package com.dimitri;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "'', ''",
            "'a', 'a'",
            "'ab', 'ba'",
            "'Hello', 'olleH'",
            "'Готово', 'овотоГ'"  // Unicode is ok
    })
    void reverse_basicCases(String input, String expected) {
        assertEquals(expected, StringUtils.reverse(input));
    }

    @Test
    void reverse_handlesUnicodeEmoji() {
        // Emoties are okay
        assertEquals("👋🙂", StringUtils.reverse("🙂👋"));
    }

    @ParameterizedTest
    @NullSource
    void reverse_null_returnsNull(String input) {
        assertNull(StringUtils.reverse(input));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.CsvSource({
            "'', true",
            "'a', true",
            "'aa', true",
            "'ab', false",
            "'AbBa', true",
            "'Never odd or even', true",
            "'анна', true",
            "'А роза упала на лапу Азора', true",
            "'hello world', false"
    })
    void isPalindrome_basic(String input, boolean expected) {
        assertEquals(expected, StringUtils.isPalindrome(input));
    }

    @org.junit.jupiter.api.Test
    void isPalindrome_null_isFalse() {
        org.junit.jupiter.api.Assertions.assertFalse(StringUtils.isPalindrome(null));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.CsvSource({
            "'', ''",
            "'a', 'A'",
            "'hello', 'Hello'",
            "'java', 'Java'",
            "'1abc', '1abc'",
            "'äbc', 'Äbc'"
    })
    void capitalize_basic(String input, String expected) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, StringUtils.capitalize(input));
    }

    @org.junit.jupiter.api.Test
    void capitalize_null_isNull() {
        org.junit.jupiter.api.Assertions.assertNull(StringUtils.capitalize(null));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.CsvSource({
            "'', 0",
            "'bcd', 0",
            "'a', 1",
            "'E', 1",
            "'Java', 2",
            "'HELLO', 2",
            "'Queue', 4",
            "'rhythm', 0"
    })
    void countVowels_basic(String input, int expected) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, StringUtils.countVowels(input));
    }

    @org.junit.jupiter.api.Test
    void countVowels_null_isZero() {
        org.junit.jupiter.api.Assertions.assertEquals(0, StringUtils.countVowels(null));
    }

}
