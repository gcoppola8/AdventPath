package dev.coppola.adventofcode.Y2015;

import dev.coppola.adventofcode.Utils;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class D2Test {

    @Test
    void part1() {
        D2 d2 = new D2();
        assertEquals("58", d2.part1(Stream.of("2x3x4")));
        assertEquals("43", d2.part1(Stream.of("1x1x10")));
        assertEquals("1606483", d2.part1(Utils.readFileAsStream("2015_2.txt")));
    }

    @Test
    void part2() {
        D2 d2 = new D2();
        assertEquals("34", d2.part2(Stream.of("2x3x4")));
        assertEquals("14", d2.part2(Stream.of("1x1x10")));
        assertEquals("3842356", d2.part2(Utils.readFileAsStream("2015_2.txt")));

    }
}