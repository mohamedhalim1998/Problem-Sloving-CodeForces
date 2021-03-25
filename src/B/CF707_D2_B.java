package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF707_D2_B {
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        if (k == n || k == 0) {
            System.out.println(-1);
            return;
        }
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int d = scanner.nextInt();
            graph.get(a).add(new Edge(b, d));
            graph.get(b).add(new Edge(a, d));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(scanner.nextInt() - 1);
        }
        long min = Long.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>(set);
        long[] dist = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        for (int x : set) {
            dist[x] = 0;
        }
        while (!queue.isEmpty()) {
            int x = queue.remove();
            if (!visited[x]) {
                visited[x] = true;
                ArrayList<Edge> list = graph.get(x);
                for (Edge e : list) {
                    if (!visited[e.n]) {
                        dist[e.n] = Math.min(dist[e.n], dist[x] + e.d);
                        queue.add(e.n);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                min = Math.min(dist[i], min);
            }
        }
        if (min == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);

    }

    private static class Edge {
        int n, d;

        public Edge(int n, int d) {
            this.n = n;
            this.d = d;
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
    }


}