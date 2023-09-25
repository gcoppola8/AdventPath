package dev.coppola.adventofcode.Y2015;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class D4 {

    public String part1(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int i = -1;
        boolean validHash = false;
        do {
            i++;
            String digest = calcHash(input, md, i);
            validHash = validHash(digest);
        } while (validHash != true);

        return String.valueOf(i);
    }

    private String calcHash(String input, MessageDigest md, int i) {
        boolean validHash;
        md.update((input + i).getBytes());
        String hex = HexFormat.of().formatHex(md.digest());
//        System.out.println(String.format("Hash of %s is %s", input + i, hex));
        return hex;
    }

    private boolean validHash(String digest) {
        return digest.charAt(0) == '0'
                && digest.charAt(1) == '0'
                && digest.charAt(2) == '0'
                && digest.charAt(3) == '0'
                && digest.charAt(4) == '0';
    }

    private boolean validHash6(String digest) {
        return validHash(digest) && digest.charAt(5) == '0';
    }

    @Test
    public void testPrivates() throws NoSuchAlgorithmException {
        assertEquals(true, validHash("00000"));
        assertEquals(true, validHash("000001012"));
        assertEquals(false, validHash("00201"));

        assertEquals(true, validHash(calcHash("abcdef", MessageDigest.getInstance("MD5"), 609043)));
    }

    public String part2(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int i = -1;
        boolean validHash = false;
        do {
            i++;
            String digest = calcHash(input, md, i);
            validHash = validHash6(digest);
        } while (validHash != true);

        return String.valueOf(i);
    }
}
