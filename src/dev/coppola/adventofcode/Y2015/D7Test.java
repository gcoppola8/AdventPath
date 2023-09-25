package dev.coppola.adventofcode.Y2015;

import dev.coppola.adventofcode.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class D7Test {

    @Test
    void testCommandProcessing() {
        String test = """
                123 -> x
                456 -> y
                x AND y -> d
                x OR y -> e
                x LSHIFT 2 -> f
                y RSHIFT 2 -> g
                NOT x -> h
                NOT y -> i
                """;

        D7 d7 = new D7();
        String[] lines = test.split("\\n");
        Arrays.stream(lines).forEach(d7::interpret);

        assertEquals(72, d7.getWire("d"));
        assertEquals(507, d7.getWire("e"));
        assertEquals(492, d7.getWire("f"));
        assertEquals(114, d7.getWire("g"));
        assertEquals(65412, d7.getWire("h"));
        assertEquals(65079, d7.getWire("i"));
        assertEquals(123, d7.getWire("x"));
        assertEquals(456, d7.getWire("y"));

        System.out.println(d7);
    }

    @Test
    void part1() {
        D7 d7 = new D7();
        assertEquals("46065", d7.part1(Utils.readFileAsStream("2015_7.txt")));
    }

    @Test
    void part2() {
        D7 d7 = new D7();
        assertEquals("14134", d7.part2(Utils.readFileAsStream("2015_7.txt")));
    }
}