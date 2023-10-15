package dev.coppola.crackingcodeinterview;

import java.util.HashMap;
import java.util.Map;

public class Chapter1 {

    private static void mapString(String input, Map<Character, Integer> map) {
        for (char c : input.toCharArray()) {
            map.computeIfPresent(c, (key, oldValue) -> ++oldValue);
            map.putIfAbsent(c, 1);
        }
    }

    /**
     * This implementation doesn't use other data structure except the string in input
     *
     * @param input string
     * @return true if the string is made by only unique characters
     */
    public boolean isUnique(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            char ref = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                if (ref == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This implementation use a HashMap to improve time complexity
     *
     * @param input string
     * @return true if the string is made by only unique characters
     */
    public boolean isUnique2(String input) {
        HashMap<Character, Boolean> chars = new HashMap<>();
        for (char x : input.toCharArray()) {
            if (chars.containsKey(x)) {
                return false;
            }

            chars.put(x, true);
        }

        return true;
    }

    /**
     * Check if two strings are one the permutation of the other
     *
     * @param str1
     * @param str2
     * @return true if str1 is a permutation of str2
     */
    public boolean checkPermutation(String str1, String str2) {
        HashMap<Character, Integer> chars1 = new HashMap<>();
        HashMap<Character, Integer> chars2 = new HashMap<>();

        for (char x : str1.toCharArray()) {
            if (chars1.computeIfPresent(x, (key, oldValue) -> oldValue + 1) == null) {
                chars1.put(x, 1);
            }
        }

        for (char x : str2.toCharArray()) {
            if (chars2.computeIfPresent(x, (key, oldValue) -> oldValue + 1) == null) {
                chars2.put(x, 1);
            }
        }

        return chars1.equals(chars2);
    }

    /**
     * @param input char[] array
     * @param size  array's size
     * @return the urlified version of the string
     */
    public String URLify(char[] input, int size) {
        if (input == null || input.length == 0) {
            return "";
        }

        int i = 0;
        while (i < size) {
            if (Character.isSpaceChar(input[i])) {

                for (int j = input.length - 1; j > i; j--) {
                    input[j] = input[j - 1];
                }

                for (int j = input.length - 1; j > i; j--) {
                    input[j] = input[j - 1];
                }

                input[i] = '%';
                input[i + 1] = '2';
                input[i + 2] = '0';

            }
            i++;
        }

        return String.valueOf(input);
    }

    /**
     * Example: baacb -> true because permutation of abcba
     *
     * @param input string in input to check
     * @return true if the string is a permutation of a palindrome
     */
    public boolean isPalindromePermutation(String input) {
        Map<Character, Integer> map = new HashMap<>();

        mapString(input, map);

        int odds = 0;

        for (Integer occurrence : map.values()) {
            if (occurrence % 2 != 0) {
                odds++;
            }
        }

        return input.length() % 2 == 0 ? odds == 0 : odds == 1;
    }

    /**
     * Check if between 2 strings the difference are one char replacemente, one char insert or one char delete
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean editDistance1(String str1, String str2) {
        int missing = 0;
        int difference = 0;

        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    difference++;
                }
            }
        }

        if (Math.abs(str1.length() - str2.length()) == 1) {

            String s1 = str1.length() < str2.length() ? str1 : str2;
            String s2 = str1.length() < str2.length() ? str2 : str1;

            int index1 = 0;
            int index2 = 0;

            while (index2 < s2.length() && index1 < s1.length()) {
                if (s1.charAt(index1) != s2.charAt(index2)) {
                    if (index1 != index2) {
                        return false;
                    }
                    index2++;
                } else {
                    index1++;
                    index2++;
                }
            }

            difference = 1;
        }

        return (missing == 0 && difference == 1) || (missing == 1 && difference == 0);
    }

    /**
     * Compress a string by replacing chars repetitions with <char><number of repetitions>
     * If the compressed string is not shorter than the original, return the original string.
     *
     * @param input
     * @return
     */
    public String compressString(String input) {
        StringBuilder sb = new StringBuilder();

        char lastChar = ',';
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == lastChar) {
                count++;
            } else {
                if (count > 2) {
                    sb.append(lastChar);
                    sb.append(count);
                } else if (count == 2) {
                    sb.append(lastChar);
                    sb.append(lastChar);
                } else if (count == 1) {
                    sb.append(lastChar);
                }

                lastChar = c;
                count = 1;
            }
        }

        if (count > 2) {
            sb.append(lastChar);
            sb.append(count);
        } else if (count == 2) {
            sb.append(lastChar);
            sb.append(lastChar);
        } else if (count == 1) {
            sb.append(lastChar);
        }

        if (sb.toString().length() < input.length()) {
            return sb.toString();
        }

        return input;
    }


    public void rotateMatrix(int[][] mat) {
        int tmp;
        int n = mat.length;

        // Rotation on the diagonal
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Rotation on the middle column
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = temp;
            }
        }

    }


    public void zeroMatrix(int[][] mat) {
        int n = mat.length;
        int[] zeroIndexX = new int[n*n];
        int[] zeroIndexY = new int[n*n];
        int count = 0;

        // Rotation on the diagonal
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    zeroIndexX[count] = i;
                    zeroIndexY[count] = j;

                    count++;
                }
            }
        }

        for (int i = 0; i < count; ++i) {
            int x = zeroIndexX[i];
            int y = zeroIndexY[i];

            for (int j = 0; j < n; j++) {
                mat[x][j] = 0;
            }

            for (int j = 0; j < n; j++) {
                mat[j][y] = 0;
            }
        }

    }


    public boolean isStringRotation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() == str2.length() && !str1.isEmpty()) {

        }
    }
}
