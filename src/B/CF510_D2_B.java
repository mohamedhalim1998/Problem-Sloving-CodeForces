package B;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CF510_D2_B {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n * m; i++) {
            graph.add(new ArrayList<>());
        }
        char[][] gird = new char[n][m];
        for (int i = 0; i < n; i++) {
            gird[i] = scanner.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int node = i * m + j;
                if (i + 1 < n) {
                    graph.get(node).add(new Edge((i + 1) * m + j, gird[i + 1][j]));
//                    if (j + 1 < m) {
//                        graph.get(node).add(new Edge((i + 1) * m + (j + 1), gird[i + 1][j + 1]));
//                    }
//                    if (j - 1 > 0) {
//                        graph.get(node).add(new Edge((i + 1) * m + (j - 1), gird[i + 1][j - 1]));
//                    }
                }
                if (i - 1 >= 0) {
                    graph.get(node).add(new Edge((i - 1) * m + j, gird[i - 1][j]));
//                    if (j + 1 < m) {
//                       graph.get(node).add(new Edge((i - 1) * m + (j + 1), gird[i - 1][j + 1]));
//                    }
//                    if (j - 1 > 0) {
//                        graph.get(node).add(new Edge((i - 1) * m + (j - 1), gird[i - 1][j - 1]));
//                    }
                }
                if (j + 1 < m) {
                    graph.get(node).add(new Edge(i * m + (j + 1), gird[i][j + 1]));
                }
                if (j - 1 >= 0) {
                    graph.get(node).add(new Edge(i * m + (j - 1), gird[i][j - 1]));
                }
            }
        }

        if (dfs(gird, n, m)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean dfs(char[][] grid, int n, int m) {
        int size = graph.size();
        int[] visited = new int[graph.size()];
        for (int i = 0; i < size; i++) {
            if (visited[i] == 0) {
                char color = grid[i / m][i % m];
                boolean cycle = cycle(i, visited, color, -1);
                if (cycle) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean cycle(int v, int[] visited, char color, int parent) {
        visited[v] = 1;
        for (Edge edge : graph.get(v)) {
            if (visited[edge.node] == 0 && edge.color == color) {
                if (cycle(edge.node, visited, color, v))
                    return true;
            } else if (edge.node != parent && edge.color == color) {
                return true;
            }
        }
        return false;


//        Stack<Integer> stack = new Stack<>();
//        stack.add(i);
//        long nodes = 0;
//        long edges = 0;
//        while (!stack.isEmpty()) {
//            int x = stack.pop();
//            if (visited[x] != 1) {
//                visited[x] = 1;
//                nodes++;
//            } else {
//                continue;
//            }
//            for (Edge edge : graph.get(x)) {
//                if (visited[edge.node] == 0 && edge.color == color) {
//                    edges++;
//                    stack.push(edge.node);
//                }
//            }
//        }
//        if(nodes == 1)
//            return false;
//
//        return edges == nodes;
    }

    public static class Edge {
        int node;
        char color;

        public Edge(int node, char color) {
            this.node = node;
            this.color = color;
        }
    }
}
