package dev.coppola.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class Utils {

    public static Stream<String> readFileAsStream(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("resources" + File.separator + fileName));
            return bufferedReader.lines();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
