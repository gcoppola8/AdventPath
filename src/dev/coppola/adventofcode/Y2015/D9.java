package dev.coppola.adventofcode.Y2015;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
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

    Function<? super String, Double> minimumTraversal = (vertex) -> {
        Map<String, Boolean> visited = new HashMap<>();
        Set<DefaultWeightedEdge> adiacents = g.edgesOf(vertex);

        double result = 0;

        while (visited.size() < g.vertexSet().size()) {
            Optional<DefaultWeightedEdge> nearest = adiacents.stream()
                    // of all unvisited vertexes
                    .filter((e) -> !visited.containsKey(g.getEdgeTarget(e)))
                    // take the nearest
                    .min((o1, o2) -> g.getEdgeWeight(o1) > g.getEdgeWeight(o2) ? 1 : -1);

            if (nearest.isPresent()) {
                result += g.getEdgeWeight(nearest.get());
            }

            visited.putIfAbsent(vertex, true);
        }

        return result;
    };

    public String part1(Stream<String> input) {
        input.forEach(buildGraph);
        Optional<Double> distances = g.vertexSet()
                .stream()
                .map((g) -> minimumTraversal.apply(g))
                .sorted()
                .findFirst();



        return "";
    }

    public String part2(Stream<String> input) {
        return "";
    }
}
