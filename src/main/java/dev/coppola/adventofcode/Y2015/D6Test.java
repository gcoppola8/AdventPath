package dev.coppola.adventofcode.Y2015;

import dev.coppola.adventofcode.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class D6Test {

    public static final String[] testInput = {
            "turn on 0,0 through 19,19",
            "turn off 3,3 through 5,7"
    };

    @Test
    void part1() {
        D6 d6 = new D6();
        assertEquals("400410", d6.part1(Utils.readFileAsStream("2015_6.txt")));
    }

    @Test
    void part2() {
        D6 d6 = new D6();
        assertEquals("15343601", d6.part2(Utils.readFileAsStream("2015_6.txt")));
    }
}