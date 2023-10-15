package dev.coppola.crackingcodeinterview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter1Test {

    private final static Chapter1 chapter1 = new Chapter1();
    private final static Logger logger = LogManager.getLogger(Chapter1Test.class);


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


    @Test
    public void testRotateMatrix() {
        int[][] testMat = new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        int[][] expectedMat = new int[][]{
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };

        chapter1.rotateMatrix(testMat);

        logger.info("--------");
        for (int i = 0; i < 5; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(testMat[i][j]).append(" ");
            }
            logger.info(sb.toString());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(expectedMat[i][j], testMat[i][j]);
            }
        }
    }

    @Test
    public void testZeroMatrix() {
        int[][] testMat = new int[][]{
                {1, 2, 0, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 0, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        int[][] expectedMat = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 0, 0, 4, 5},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 4, 5},
                {1, 0, 0, 4, 5}
        };

        chapter1.zeroMatrix(testMat);

        logger.info("--------");
        for (int i = 0; i < 5; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                sb.append(testMat[i][j]).append(" ");
            }
            logger.info(sb.toString());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(expectedMat[i][j], testMat[i][j]);
            }
        }

    }

    @Test
    public void testStringRotation() {
        assertTrue(chapter1.isStringRotation("il cane amico", "micoil cane a"));
        assertFalse(chapter1.isStringRotation("cane", "arancia"));
    }
}
