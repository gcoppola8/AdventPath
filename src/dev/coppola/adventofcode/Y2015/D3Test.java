package dev.coppola.adventofcode.Y2015;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class D3Test {

    @Test
    public void test1() {
        D3 d3 = new D3();
        assertEquals("1", d3.part1(""));
        assertEquals("2", d3.part1("^"));
        assertEquals("2", d3.part1("^v^v^v^v^v"));
        assertEquals("2081", d3.part1(d3.getInput()));
    }

    @Test
    public void test2() {
        D3 d3 = new D3();
        assertEquals("1", d3.part2(""));
        assertEquals("3", d3.part2("^v"));
        assertEquals("3", d3.part2("^>v<"));
        assertEquals("11", d3.part2("^v^v^v^v^v"));
        assertEquals("2341", d3.part2(d3.getInput()));
    }

}