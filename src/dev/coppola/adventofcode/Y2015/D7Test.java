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

        assertEquals(8, d7.vars.size());
        

        System.out.println(d7);
    }

    @Test
    void part1() {
        D7 d7 = new D7();
        assertEquals("0", d7.part1(Utils.readFileAsStream("2015_7.txt")));
    }

    @Test
    void part2() {
        D7 d7 = new D7();
        assertEquals("15343601", d7.part2(Utils.readFileAsStream("2015_7.txt")));
    }
}