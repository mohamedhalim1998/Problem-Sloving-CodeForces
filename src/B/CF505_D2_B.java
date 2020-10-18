package B;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class CF505_D2_B {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(n1).add(new Edge(n2, c));
            graph.get(n2).add(new Edge(n1, c));
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            System.out.println(dfs(s, e));
        }

    }

    private static int dfs(int s, int e) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (Edge edge : graph.get(s)) {
            set.add(edge.color);
        }
        for (int i : set) {

            if (dfsHelper(s, e, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean dfsHelper(int s, int e, int color) {
        boolean ans = false;
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        int[] visited = new int[graph.size()];
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (x == e) {
                ans = true;
                break;
            }
            visited[x] = 1;
            for (Edge edge : graph.get(x)) {

                if (edge.color == color && visited[edge.node] == 0) {
                    stack.push(edge.node);
                }
            }
        }
        return ans;
    }

    static class Edge {
        int node;
        int color;

        public Edge(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
}
