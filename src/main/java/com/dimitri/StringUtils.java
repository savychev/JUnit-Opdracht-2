package com.dimitri;

public final class StringUtils {
    private StringUtils() { }

    /**
     * reverse(null) -> null
     * reverse("") -> ""
     * reverse("abc") -> "cba"
     */
    public static String reverse(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Палиндром: сравнение без пробелов, без учёта регистра.
     * null -> false; "" -> true
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        String normalized = s.replaceAll("\\s+", "").toLowerCase();
        return new StringBuilder(normalized).reverse().toString().equals(normalized);
    }

    /**
     * Делает первый символ строки заглавным, остальные не трогаем.
     * null -> null; "" -> ""; "hello" -> "Hello"; "1abc" -> "1abc"
     */
    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        char first = s.charAt(0);
        return Character.toUpperCase(first) + s.substring(1);
    }

    /**
     * Считает гласные a/e/i/o/u (оба регистра). Для null или "" -> 0.
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
