package dev.coppola.adventofcode.Y2015;

import java.util.HashMap;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class D7 {

    public static final int MIN = 0;
    public static final int MAX = 65536;

    public HashMap<String, Node> vars = new HashMap<>();
    public HashMap<String, String> edges = new HashMap<>();
    public static HashMap<String, IntBinaryOperator> opCodes = new HashMap<>();

    static {
        opCodes.put("AND", (a, b) -> a & b);
        opCodes.put("OR", (a, b) -> a | b);
        opCodes.put("LSHIFT", (a, b) -> a << b);
        opCodes.put("RSHIFT", (a, b) -> a >> b);
        opCodes.put("->", (a, b) -> a);
    }
    public String part1(Stream<String> input) {
        input.forEach((line) -> {
            interpret(line);
        });
        return String.valueOf(getWire("a"));
    }

    public String part2(Stream<String> input) {
        return "";
    }

    public void interpret(String line) {
        String[] cmd = line.split(" ");

        if (cmd[0].equals("NOT")) {
            Node node = new Node((a, b) -> 65536 - a, 0, cmd[1], null, "NOT");
            vars.put(cmd[3], node);
        } else if (cmd[1].equals("->")) {
            Node wire = new Node(null, 0, cmd[0], null, "ASSIGN");
            vars.put(cmd[2], wire);
        } else {
            Node node = new Node(opCodes.get(cmd[1]), 0, cmd[0], cmd[2], cmd[1]);
            vars.put(cmd[4], node);
        }
    }

    public Node getWire(String symbol) {
        Node node = vars.get(symbol);
        System.out.println("Read symbol " + symbol + " with value " + node);
        if (node.value() == 0) {
            if ("ASSIGN".equals(node.type())) {
                Node wire = getWire(node.a());
                Node update = new Node(node.op(), wire.value(), node.a(), node.b(), node.type());
                vars.put(symbol, update);
            } else if ("NOT".equals(node.type())) {
                Node wire = getWire(node.a());
                Node update = new Node(node.op(), node.op().applyAsInt(wire.value(), 0), node.a(), node.b(), node.type());
                vars.put(symbol, update);
            } else if ("AND".equals(node.type()) || "OR".equals(node.type()) || "LSHIFT".equals(node.type()) || "RSHIFT".equals(node.type())) {
                Node a = getWire(node.a());
                Node b = getWire(node.b());
                Node update = new Node(node.op(), node.op().applyAsInt(a.value(), b.value()), node.a(), node.b(), node.type());
                vars.put(symbol, update);
            }
        } else {
            return new Node(null, node.value(), null, null, "ASSIGN");
        }
        return vars.get(symbol);
    }

    record Node (IntBinaryOperator op, int value, String a, String b, String type){ }

    @Override
    public String toString() {
        return "D7{" +
                "vars=" + vars.entrySet() +
                '}';
    }
}
