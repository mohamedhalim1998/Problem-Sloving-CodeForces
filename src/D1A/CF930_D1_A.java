package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF930_D1_A {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            int a = scanner.nextInt();
            graph.get(a).add(i);
            graph.get(i).add(a);
        }
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        dfs(1, 1, visited, depth);
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int x : depth) {
            set.put(x, set.getOrDefault(x, 0) + 1);
        }
        int count = -1;
        for (Map.Entry<Integer, Integer> e : set.entrySet()) {
            count += e.getValue() %  2;
        }
//        System.out.println(Arrays.toString(depth));
        System.out.println(count);
    }

    private static void dfs(int i, int d, boolean[] visited, int[] depth) {
        if (!visited[i]) {
            visited[i] = true;
            depth[i] = d;
        }
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                dfs(x, d + 1, visited, depth);
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