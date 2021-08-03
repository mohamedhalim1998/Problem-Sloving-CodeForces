package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1130_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int a = (scanner.nextInt() - 1) * n + scanner.nextInt() - 1;
        int b = (scanner.nextInt() - 1) * n + scanner.nextInt() - 1;

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        for (int i = 0; i < n * n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    continue;
                }
                if (isValid(i + 1, j, n) && grid[i + 1][j] == '0') {
                    graph.get(i * n + j).add((i + 1) * n + j);
                    graph.get((i + 1) * n + j).add(i * n + j);
                }
                if (isValid(i - 1, j, n) && grid[i - 1][j] == '0') {
                    graph.get(i * n + j).add((i - 1) * n + j);
                    graph.get((i - 1) * n + j).add(i * n + j);
                }
                if (isValid(i, j + 1, n) && grid[i][j + 1] == '0') {
                    graph.get(i * n + j).add(i * n + j + 1);
                    graph.get(i * n + j + 1).add(i * n + j);
                }
                if (isValid(i, j - 1, n) && grid[i][j - 1] == '0') {
                    graph.get(i * n + j).add(i * n + j - 1);
                    graph.get(i * n + j - 1).add(i * n + j);
                }
            }
        }
        ArrayList<Integer> start = new ArrayList<>();
        boolean[] visited = new boolean[n * n];
        Stack<Integer> stack = new Stack<>();
        stack.add(a);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            start.add(curr);
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.add(x);
                }
            }
        }
        if (visited[b]) {
            System.out.println(0);
            return;
        }
        ArrayList<Integer> goal = new ArrayList<>();
        visited = new boolean[n * n];
        stack = new Stack<>();
        stack.add(b);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            goal.add(curr);
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.add(x);
                }
            }
        }
        long min = Integer.MAX_VALUE;
        for (int x : start) {
            for (int y : goal) {
                int r1 = x / n + 1;
                int c1 = x % n + 1;
                int r2 = y / n + 1;
                int c2 = y % n + 1;
                min = (long) Math.min(Math.pow(r1 - r2, 2) + Math.pow(c1 - c2, 2), min);
            }
        }
        System.out.println(min);

    }

    static boolean isValid(int x, int y, int n) {
        return x < n && x >= 0 && y < n && y >= 0;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}