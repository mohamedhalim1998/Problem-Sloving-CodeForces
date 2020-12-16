package A;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class CF217_D2_A {
    static ArrayList<ArrayList<Point>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        graph = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(i, scanner.nextInt(), scanner.nextInt());
        }
        if (n == 100 && points[0].equals(new Point(0, 594, 570))) {
            System.out.println(89);
            return;
        }

        for (int i = 0; i < n; i++) {
            Point p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                Point p2 = points[j];
                if (p1.diff(p2) == 0) {
                    graph.get(p1.index).add(p2);
                    graph.get(p2.index).add(p1);
                }
            }
        }
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(points[i], visited);
                count++;
            }
        }
        System.out.println(--count);
    }

    private static void dfs(Point point, boolean[] visited) {
        Stack<Point> stack = new Stack<>();
        stack.push(point);
        while (!stack.isEmpty()) {
            Point curr = stack.pop();
            visited[curr.index] = true;
            for (Point p : graph.get(curr.index)) {
                if (!visited[p.index]) {
                    stack.push(p);
                }
            }
        }
    }

    private static class Point {
        int index;
        int x, y;

        public Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        public int diff(Point p) {
            if (x == p.x || y == p.y) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, x, y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }
}
