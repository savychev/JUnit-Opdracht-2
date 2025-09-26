package com.dimitri;

public final class StringUtils {
    private StringUtils() { }

    /**
     * String reverser.
     * reverse(null) -> null; reverse("") -> ""; reverse("abc") -> "cba"
     */
    public static String reverse(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Palindrome: compare ignoring spaces and case.
     * null -> false; "" -> true
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        String normalized = s.replaceAll("\\s+", "").toLowerCase(); // normalization: removes all whitespace with regex (spaces, tabs, newlines), makes all letters lowercase
        return new StringBuilder(normalized).reverse().toString().equals(normalized);
    }

    /**
     * Make the first letter capitalized.
     * null -> null; "" -> ""; "hello" -> "Hello"; "1abc" -> "1abc"
     */
    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        char first = s.charAt(0);
        return Character.toUpperCase(first) + s.substring(1);
    }

    /**
     * null -> 0
     * "" -> 0
     * Count vowels a/e/i/o/u
     */
    public static int countVowels(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (Character.toLowerCase(s.charAt(i))) {
                case 'a', 'e', 'i', 'o', 'u' -> count++;
            }
        }
        return count;
    }
}
