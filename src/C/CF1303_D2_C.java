package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1303_D2_C {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);

    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        String s = scanner.next();
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i + 1) - 'a';
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 0; i < 26; i++) {
            if (graph.get(i).size() > 2) {
                out.append("NO\n");
                return;
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < 26; i++) {
            if (graph.get(i).size() == 1) {
                boolean[] visited = new boolean[26];
                found = true;
                dfs(graph, visited, i, builder);
                break;
            }
        }
        if (found || s.length() == 1) {
            for (int i = 0; i < 26; i++) {
                if (graph.get(i).size() == 0) {
                    char c = (char) (i + 'a');
                    builder.append(c);
                }
            }
            out.append("YES\n");
            out.append(builder).append("\n");
        } else {
            out.append("NO\n");
        }

    }

    private static void dfs(ArrayList<HashSet<Integer>> graph, boolean[] visited, int i, StringBuilder builder) {
        visited[i] = true;
        char c = (char) (i + 'a');
        builder.append(c);
        for (int x : graph.get(i)) {
            if (!visited[x])
                dfs(graph, visited, x, builder);
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