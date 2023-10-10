package dev.coppola.adventofcode.Y2015;

import java.util.stream.Stream;

public class D6 {

    private static int[] getCoordinates(String split) {
        String[] coordinates = split.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        return new int[]{x, y};
    }

    private static int getCount(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public String part1(Stream<String> input) {
        int grid[][] = new int[1000][1000];

        input.forEach((line) -> {
            String[] split = line.split(" ");
            if ("turn on".equals(split[0] + " " + split[1])) {
                int[] x_y_0 = getCoordinates(split[2]);
                int[] x_y_1 = getCoordinates(split[4]);

                turnOn(grid, x_y_0, x_y_1);
            }
            if ("turn off".equals(split[0] + " " + split[1])) {
                int[] x_y_0 = getCoordinates(split[2]);
                int[] x_y_1 = getCoordinates(split[4]);

                turnOff(grid, x_y_0, x_y_1);
            }
            if ("toggle".equals(split[0])) {
                int[] x_y_0 = getCoordinates(split[1]);
                int[] x_y_1 = getCoordinates(split[3]);

                toggle(grid, x_y_0, x_y_1);
            }
        });

        int count = getCount(grid);

        return String.valueOf(count);
    }

    private void toggle(int[][] grid, int[] x_y_0, int[] x_y_1) {
        int x0 = x_y_0[0];
        int x1 = x_y_1[0];
        int y0 = x_y_0[1];
        int y1 = x_y_1[1];

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }
    }

    private void turnOff(int[][] grid, int[] x_y_0, int[] x_y_1) {
        int x0 = x_y_0[0];
        int x1 = x_y_1[0];
        int y0 = x_y_0[1];
        int y1 = x_y_1[1];

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                grid[i][j] = 0;
            }
        }
    }

    private void turnOn(int[][] grid, int[] x_y_0, int[] x_y_1) {
        int x0 = x_y_0[0];
        int x1 = x_y_1[0];
        int y0 = x_y_0[1];
        int y1 = x_y_1[1];

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                grid[i][j] = 1;
            }
        }
    }

    public String part2(Stream<String> input) {
        int grid[][] = new int[1000][1000];

        input.forEach((line) -> {
            String[] split = line.split(" ");
            if ("turn on".equals(split[0] + " " + split[1])) {
                int[] x_y_0 = getCoordinates(split[2]);
                int[] x_y_1 = getCoordinates(split[4]);

                turnOn2(grid, x_y_0, x_y_1);
            }
            if ("turn off".equals(split[0] + " " + split[1])) {
                int[] x_y_0 = getCoordinates(split[2]);
                int[] x_y_1 = getCoordinates(split[4]);

                turnOff2(grid, x_y_0, x_y_1);
            }
            if ("toggle".equals(split[0])) {
                int[] x_y_0 = getCoordinates(split[1]);
                int[] x_y_1 = getCoordinates(split[3]);

                toggle2(grid, x_y_0, x_y_1);
            }
        });

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    count += grid[i][j];
                }
            }
        }

        return String.valueOf(count);
    }

    private void toggle2(int[][] grid, int[] x_y_0, int[] x_y_1) {
        int x0 = x_y_0[0];
        int x1 = x_y_1[0];
        int y0 = x_y_0[1];
        int y1 = x_y_1[1];

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                grid[i][j] += 2;
            }
        }
    }

    private void turnOff2(int[][] grid, int[] x_y_0, int[] x_y_1) {
        int x0 = x_y_0[0];
        int x1 = x_y_1[0];
        int y0 = x_y_0[1];
        int y1 = x_y_1[1];

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                if (grid[i][j] > 0) {
                    grid[i][j]--;
                }
            }
        }
    }

    private void turnOn2(int[][] grid, int[] x_y_0, int[] x_y_1) {
        int x0 = x_y_0[0];
        int x1 = x_y_1[0];
        int y0 = x_y_0[1];
        int y1 = x_y_1[1];

        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                grid[i][j]++;
            }
        }
    }

}
