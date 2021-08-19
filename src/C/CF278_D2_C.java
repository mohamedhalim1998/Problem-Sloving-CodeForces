package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF278_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }
        int zero = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x == 0) {
                zero++;
                continue;
            }
            int a = scanner.nextInt() - 1;
            set.add(a);
            for (int j = 1; j < x; j++) {
                int b = scanner.nextInt() - 1;
                graph.get(a).add(b);
                graph.get(b).add(a);
                set.add(a);
                set.add(b);
                a = b;
            }
        }
        boolean[] visited = new boolean[m];
        int count = 0;
        for (int i : set) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        if(count > 0){
            count--;
        }

        System.out.println(count + zero);
    }

    private static void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                dfs(x, visited);
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
    }
}