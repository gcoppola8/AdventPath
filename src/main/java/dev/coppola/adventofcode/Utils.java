package dev.coppola.adventofcode;

import com.google.common.base.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class Utils {

    public static Stream<String> readFileAsStream(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(fileName), Charsets.UTF_8)).lines();
    }
}
