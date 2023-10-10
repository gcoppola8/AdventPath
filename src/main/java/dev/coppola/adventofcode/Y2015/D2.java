package dev.coppola.adventofcode.Y2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class D2 {

    public String part1(Stream<String> input) {
        AtomicLong paper = new AtomicLong();

        input.forEach(s -> {
            String measures[] = s.split("x");
            int l = Integer.parseInt(measures[0]);
            int w = Integer.parseInt(measures[1]);
            int h = Integer.parseInt(measures[2]);
            OptionalInt min = Stream.of(l * w, l * h, h * w).mapToInt(value -> value).min();
            long paper_s = calcBox(l, w, h) + min.orElse(0);
            System.out.println(String.format("Total of l %s, w %s, h %s is: %s", l, w, h, paper_s));
            paper.addAndGet(paper_s);
        });

        return String.valueOf(paper.get());
    }

    public String part2(Stream<String> input) {
        AtomicLong ribbon = new AtomicLong();

        input.forEach(s -> {
            String measures[] = s.split("x");
            int l = Integer.parseInt(measures[0]);
            int w = Integer.parseInt(measures[1]);
            int h = Integer.parseInt(measures[2]);
            int[] arr = Arrays.stream(new int[]{l, w, h}).sorted().toArray();
            long ribbon_s = arr[0] + arr[0] + arr[1] + arr[1];
            ribbon_s += l * w * h;

            ribbon.addAndGet(ribbon_s);
        });

        return String.valueOf(ribbon.get());
    }

    private long calcBox(int l, int w, int h) {
        return 2*l*w + 2*w*h + 2*h*l;
    }
}
