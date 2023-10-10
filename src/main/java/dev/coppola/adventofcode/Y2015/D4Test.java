package dev.coppola.adventofcode.Y2015;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class D4Test {

    @Test
    void part1() throws NoSuchAlgorithmException {
        D4 d4 = new D4();
        assertEquals("609043", d4.part1("abcdef"));
        assertEquals("1048970", d4.part1("pqrstuv"));
        assertEquals("282749", d4.part1("yzbqklnj"));
    }

    @Test
    void part2() throws NoSuchAlgorithmException {
        D4 d4 = new D4();
        assertEquals("9962624", d4.part2("yzbqklnj"));
    }
}