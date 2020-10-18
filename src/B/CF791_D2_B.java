package B;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CF791_D2_B {
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);

        }

        if (dfs()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean dfs() {
        int n = graph.size();
        int[] visited = new int[graph.size()];

        for (int i = 1; i < n; i++) {
            if (visited[i] != 1) {
                boolean cycle = cycle(i, visited);
                if (!cycle) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean cycle(int i, int[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        long nodes = 0;
        long edges = 0;
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (visited[x] != 1) {
                visited[x] = 1;
                nodes++;
            } else {
                continue;
            }
            for (int j : graph.get(x)) {
                if (visited[j] == 0) {
                    edges++;
                    stack.push(j);
                }
            }
        }

        return edges == (nodes * (nodes - 1)) / 2.0;
    }
}
