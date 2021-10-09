package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF982_D2_C {
    static int count = 0;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = scanner.nextInt();
        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }
        if (n == 2) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] visited = new boolean[graph.size()];

        dfs(graph, visited, 0);
        System.out.println(count - 1);


    }

    private static int dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int i) {
        int c = 1;
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                c += dfs(graph, visited, x);

            }
        }
        if (c % 2 == 0) {
            count++;
        }
        return c;
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