package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1363_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    static ArrayList<ArrayList<Integer>> graph;

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean[] visited = new boolean[n];
        dfs(x, x, visited, parent);

        if (graph.get(x).size() < 2) {
            System.out.println("Ayush");
            return;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int p = i;
            if (i == x)
                continue;
            while (parent[p] != p) {
                if (p == x) {
                    count++;
                }
                p = parent[p];
            }
            if (p == x) {
                count++;
            }
        }
        if (count % 2 == 0) {
            System.out.println("Ashish");
        } else {
            System.out.println("Ayush");
        }
//        System.out.println(count - 1);
    }

    private static void dfs(int i, int p, boolean[] visited, int[] parent) {
        parent[i] = p;
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                dfs(x, i, visited, parent);
            }
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

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}