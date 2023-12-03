package dev.coppola.adventofcode.Y2015;

import com.google.common.math.BigIntegerMath;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class D9 {

    Graph<String, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

    Consumer<? super String> buildGraph = (line) -> {
        String[] parts = line.split(" to | = ");

        g.addVertex(parts[0]);
        g.addVertex(parts[1]);

        g.addEdge(parts[0], parts[1]);
        g.setEdgeWeight(parts[0], parts[1], Double.parseDouble(parts[2]));
    };


    public String part1(Stream<String> input) {
        input.forEach(buildGraph);

        String[] set = g.vertexSet().toArray(new String[0]);
        int size = set.length;

        BigInteger factorial = BigIntegerMath.factorial(size);

        List<List<String>> mat = new ArrayList<>();

        printAllRecursive(size, set, mat);

        int[] d = new int[factorial.intValue()];

        for (int i = 0; i < factorial.longValue(); i++) {
            calculateDistance(d, mat, i, size);
        }

        int min = d[0];

        for (int i = 0; i < factorial.longValue(); i++) {
            if (min > d[i]) {
                min = d[i];
            }
        }

        return String.valueOf(min);
    }

    private void calculateDistance(int[] d, List<List<String>> mat, int i, int size) {
        int sum = 0;
        for (int j = 0; j < size - 1; j++) {
            DefaultWeightedEdge e = g.getEdge(mat.get(i).get(j), mat.get(i).get(j+1));
            double edgeWeight = g.getEdgeWeight(e);
            sum += edgeWeight;
        }
        d[i] = sum;
    }

    public static <T> void printAllRecursive(int n, T[] elements, List<List<String>> mat) {

        if(n == 1) {
            saveArray(elements, mat);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, mat);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, mat);
        }
    }

    private static <T> void saveArray(T[] elements, List<List<String>> mat) {
        mat.add((List<String>) Arrays.asList(elements.clone()));
    }

    private static <T> void swap(T[] elements, int a, int b) {
        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    public String part2(Stream<String> input) {
        input.forEach(buildGraph);

        String[] set = g.vertexSet().toArray(new String[0]);
        int size = set.length;

        BigInteger factorial = BigIntegerMath.factorial(size);

        List<List<String>> mat = new ArrayList<>();

        printAllRecursive(size, set, mat);

        int[] d = new int[factorial.intValue()];

        for (int i = 0; i < factorial.longValue(); i++) {
            calculateDistance(d, mat, i, size);
        }

        int max = d[0];

        for (int i = 0; i < factorial.longValue(); i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }

        return String.valueOf(max);
    }
}
