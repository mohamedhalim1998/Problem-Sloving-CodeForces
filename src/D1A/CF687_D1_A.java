package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF687_D1_A {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int m = scanner.nextInt();
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
            list.add(new Edge(x, y));

        }
        boolean[] visited = new boolean[n];
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, i, a, b, true);
            }
        }
        for (Edge e : list) {
            if (a.contains(e.x)) {
                if (b.contains(e.x) || !b.contains(e.y)) {
                    System.out.println(-1);
                    return;
                }
            } else {
                if (a.contains(e.x) || !a.contains(e.y)) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder out = new StringBuilder();
        out.append(a.size()).append('\n');
        for (int x : a) {
            out.append(x + 1).append(' ');
        }
        out.append('\n');
        out.append(b.size()).append('\n');
        for (int x : b) {
            out.append(x + 1).append(' ');
        }
        out.append('\n');
        System.out.print(out);
    }


    private static boolean dfs(boolean[] visited, int i, HashSet<Integer> a, HashSet<Integer> b, boolean isA) {
        if (isA) {
            a.add(i);
        } else {
            b.add(i);
        }
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                dfs(visited, x, a, b, !isA);
            }
        }
//        Stack<Integer> stack = new Stack<>();
//        stack.add(i);
//        while (!stack.isEmpty()) {
//            int curr = stack.pop();
//            if (isA && b.contains(curr)) {
//                return false;
//            }
//            if (!isA && a.contains(curr)) {
//                return false;
//            }
//            visited[curr] = true;
//            for (int x : graph.get(curr)) {
//                if (!visited[x]) {
//                    stack.add(x);
//                    if (isA) {
//                        b.add(x);
//                    } else {
//                        a.add(x);
//                    }
//                }
//            }
//            isA = !isA;
//        }
        return true;
    }

    static class Edge {
        int x, y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
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