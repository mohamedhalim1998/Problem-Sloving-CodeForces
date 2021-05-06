package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF277_D1_A {
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lang = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            lang.add(new ArrayList<>());
        }
        int langCount = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                int l = scanner.nextInt() - 1;
                lang.get(l).add(i);
                langCount++;
            }
        }
        if(langCount == 0){
            System.out.println(n);
            return;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = lang.get(i);
            for (int x : list) {
                for (int y : list) {
                    if (x != y) {
                        graph.get(x).add(y);
                        graph.get(y).add(x);
                    }
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited);
            }
        }
        System.out.println(count - 1);
    }

    private static void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x])
                dfs(x, visited);
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