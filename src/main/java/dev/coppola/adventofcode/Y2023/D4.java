package dev.coppola.adventofcode.Y2023;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class D4 {

    public String part1(Stream<String> input) {
        Map<String, Integer> playedNumbers = new HashMap<>();
        AtomicInteger sum = new AtomicInteger();

        input.forEach((line) -> {
            String[] split = line.split(":");

            String[] numbers = split[1].replace('|', ',').split(" , ");

            String[] play = numbers[0].split(" ");
            String[] res = numbers[1].split(" ");

            for (String s : play) {
                playedNumbers.put(s, 1);
            }

            int sumLine = 0;

            for (String s : res) {
                if (!s.equals("") && playedNumbers.containsKey(s)) {
                    sumLine = sumLine == 0 ? 1 : sumLine*2;
                }
            }

            sum.addAndGet(sumLine);
            playedNumbers.clear();
        });

        return String.valueOf(sum);
    }

    public String part2(Stream<String> input) {
        Map<String, Integer> playedNumbers = new HashMap<>();
        AtomicInteger sum = new AtomicInteger();
        List<String> numbersList = new ArrayList<>();

        input.forEach((line) -> {
            String[] split = line.split(":");
            String[] numbers = split[1].replace('|', ',').split(" , ");

            numbersList.add(numbers[0] + "," + numbers[1]);


        });

        return String.valueOf(sum);
    }
}
