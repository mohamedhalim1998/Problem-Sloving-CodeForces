package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF430_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int max = 0;
    static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] from = scanner.nextArray(n);
        int[] to = scanner.nextArray(n);

        boolean[] visited = new boolean[n];

        dfs(0, 0, visited, from, to, 0, 0);

        System.out.println(res.size());
        printArrayInLine(res);

    }    public static void printArrayInLine(ArrayList<Integer> arr) {
        StringBuilder builder = new StringBuilder();
        for (Object value : arr) {
            builder.append(value).append("\n");
        }
        System.out.println(builder);
    }

    private static void dfs(int i, int level, boolean[] visited, int[] from, int[] to, int even, int odd) {
        visited[i] = true;
        if (level % 2 == 0) {
            if (from[i] != to[i] && even == 0) {
                res.add(i + 1);
                even = 1;
            }
            if (from[i] == to[i] && even == 1) {
                res.add(i + 1);
                even = 0;
            }
        } else {
            if (from[i] != to[i] && odd == 0) {
                res.add(i + 1);
                odd = 1;
            }
            if (from[i] == to[i] && odd == 1) {
                res.add(i + 1);
                odd = 0;
            }
        }
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                dfs(x, level + 1, visited, from, to, even, odd);
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
    }
}
