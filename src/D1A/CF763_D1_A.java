package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF763_D1_A {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] color;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Pair[] pairs = new Pair[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            pairs[i] = new Pair(x, y);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        color = scanner.nextArray(n);
        for (Pair p : pairs) {
            if (color[p.x] != color[p.y]) {
                if(check(p.x)) {
                    System.out.println("YES");
                    System.out.println(p.x + 1);
                } else if(check(p.y)) {
                    System.out.println("YES");
                    System.out.println(p.y + 1);
                } else {
                    System.out.println("NO");
                }
                return;
            }
        }
        System.out.println("YES");
        System.out.println(1);


    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean[] dfs(int i) {
        boolean[] visited = new boolean[graph.size()];
        visited[i] = true;
        for (int x : graph.get(i)) {
            dfs(visited, x);
        }
        return visited;
    }

    static boolean check(int i) {
        boolean[] visited = dfs(i);
        boolean found = false;
        for (boolean x : visited) {
            if (!x) {
                found = true;
                break;
            }
        }
        return !found;
    }

    private static void dfs(boolean[] visited, int i) {
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x] && color[x] == color[i]) {
                dfs(visited, x);
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