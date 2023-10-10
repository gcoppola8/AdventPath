package dev.coppola.crackingcodeinterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter1Test {

    Chapter1 chapter1 = new Chapter1();

    @Test
    public void testIsUnique() {
        assertTrue(chapter1.isUnique("abcdef"));
        assertFalse(chapter1.isUnique("aa1234aa"));
        assertTrue(chapter1.isUnique(""));
        assertFalse(chapter1.isUnique("12345677"));

        assertTrue(chapter1.isUnique2("abcdef"));
        assertFalse(chapter1.isUnique2("aa1234aa"));
        assertTrue(chapter1.isUnique2(""));
        assertFalse(chapter1.isUnique2("12345677"));
    }

    @Test
    public void testCheckPermutation() {
        assertTrue(chapter1.checkPermutation("", ""));
        assertTrue(chapter1.checkPermutation("a", "a"));
        assertTrue(chapter1.checkPermutation("abcfde", "edfcba"));
        assertFalse(chapter1.checkPermutation("abc2fde", "ed1fcba"));
    }

    @Test
    public void testURLify() {
        char[] buff = "arti cle1 544        ".toCharArray();
        assertEquals("", chapter1.URLify(null, 0));
        assertEquals("", chapter1.URLify(new char[]{}, 0));
        assertEquals("ciao", chapter1.URLify(new char[]{'c', 'i', 'a', 'o'}, 4));
        assertEquals("arti%20cle1%20544", chapter1.URLify(buff, 13).trim());
    }

    @Test
    public void testPalindromePermutation() {
        assertTrue(chapter1.isPalindromePermutation(""));
        assertTrue(chapter1.isPalindromePermutation("a"));
        assertTrue(chapter1.isPalindromePermutation("123454321"));
        assertTrue(chapter1.isPalindromePermutation("12344321"));
        assertTrue(chapter1.isPalindromePermutation("abahcbch"));

        assertFalse(chapter1.isPalindromePermutation("abc"));
        assertFalse(chapter1.isPalindromePermutation("b2ab"));
        assertFalse(chapter1.isPalindromePermutation("1233333"));
    }

    @Test
    public void testEditDistance1() {
        assertTrue(chapter1.editDistance1("aaa", "aab"));
        assertTrue(chapter1.editDistance1("", " "));
        assertTrue(chapter1.editDistance1(" ", ""));
        assertTrue(chapter1.editDistance1("aa", "a a"));
        assertTrue(chapter1.editDistance1("aajaaai", "aaaaai"));
        assertTrue(chapter1.editDistance1("ajaaai", "aajaaai"));

        assertFalse(chapter1.editDistance1("a", "a"));
        assertFalse(chapter1.editDistance1("aj", ""));
        assertFalse(chapter1.editDistance1("", "aj"));
        assertFalse(chapter1.editDistance1("abcdef", "a"));
    }


    @Test
    public void testCompressString() {
        assertEquals("", chapter1.compressString(""));
        assertEquals("a", chapter1.compressString("a"));
        assertEquals("a3", chapter1.compressString("aaa"));
        assertEquals("a3b5ddo4", chapter1.compressString("aaabbbbbddoooo"));
        assertEquals("aabbccdd", chapter1.compressString("aabbccdd"));
        assertEquals("abcd", chapter1.compressString("abcd"));
    }


}
