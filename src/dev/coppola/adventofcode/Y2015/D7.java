package dev.coppola.adventofcode.Y2015;

import java.util.HashMap;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class D7 {

    public static final int MIN = 0;
    public static final int MAX = 65536;

    private HashMap<String, Node> vars = new HashMap<>();

    private HashMap<String, Integer> values = new HashMap<>();
    public static HashMap<String, IntBinaryOperator> opCodes = new HashMap<>();

    static {
        opCodes.put("AND", (a, b) -> a & b);
        opCodes.put("OR", (a, b) -> a | b);
        opCodes.put("LSHIFT", (a, b) -> a << b);
        opCodes.put("RSHIFT", (a, b) -> a >> b);
    }

    public String part1(Stream<String> input) {
        input.forEach((line) -> {
            interpret(line);
        });
        return String.valueOf(getWire("a"));
    }

    public String part2(Stream<String> input) {
        input.forEach((line) -> {
            interpret(line);
        });

        // assign a signal to b and rerun the calculation
        setSignal("b", 46065);

        return String.valueOf(getWire("a"));
    }

    public void interpret(String line) {
        String[] cmd = line.split(" ");

        if (cmd[0].equals("NOT")) {
            addElement(new Node(cmd[3], cmd[1], null, "NOT"));
        } else if (cmd[1].equals("->")) {
            try {
                setSignal(cmd[2], Integer.parseInt(cmd[0]));
            } catch (NumberFormatException nfe) {
                // ignore
            }

            addElement(new Node(cmd[2], cmd[0], null, "ASSIGN"));
        } else {
            addElement(new Node(cmd[4], cmd[0], cmd[2], cmd[1]));
        }
    }

    public Integer getWire(String symbol) {
        Node node = getElement(symbol);

        if (node == null) {
            return null;
        }

        if (isMissingSignal(symbol)) {
            getWire(node.a());
            getWire(node.b());

//            System.out.println("Calculate symbol " + symbol + " with value " + node);
            if ("ASSIGN".equals(node.type())) {
                setSignal(node.symbol, getSignal(node.a()));
            } else if ("NOT".equals(node.type())) {
                setSignal(node.symbol(), 65535 - getSignal(node.a()));
            } else {
                int left, right;

                try {
                    left = Integer.parseInt(node.a());
                } catch (NumberFormatException nfe) {
                    left = getSignal(node.a());
                }

                try {
                    right = Integer.parseInt(node.b());
                } catch (NumberFormatException nfe) {
                    right = getSignal(node.b());
                }

                setSignal(node.symbol(),
                        opCodes.get(node.type()).applyAsInt(
                                left,
                                right
                        ));

            }
        }

        return values.get(node.symbol());
    }

    public void setSignal(String symbol, int val) {
        values.put(symbol, val);
    }

    public Integer getSignal(String symbol) {
        return values.get(symbol);
    }

    public void addElement(Node node) {
        vars.put(node.symbol(), node);
    }

    public Node getElement(String symbol) {
        return vars.get(symbol);
    }

    public boolean isMissingSignal(String symbol) {
        return !values.containsKey(symbol);
    }

    private record Node (String symbol, String a, String b, String type){ }

    @Override
    public String toString() {
        return "D7{" +
                "vars=" + vars.entrySet() +
                "values=" + values.entrySet() +
                '}';
    }
}
