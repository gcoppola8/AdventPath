package dev.coppola.adventofcode.Y2015;

import dev.coppola.adventofcode.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class D9Test {

    @Test
    void testCommandProcessing() {
        String test = """
                London to Dublin = 464
                London to Belfast = 518
                Dublin to Belfast = 141
                """;

        D9 d9 = new D9();
        d9.part1(test.lines());
    }

    @Test
    void part1() {
        D9 d9 = new D9();
        assertEquals("", d9.part1(Utils.readFileAsStream("2015_9.txt")));
    }

    @Test
    void part2() {
        D9 d9 = new D9();
    }
}
