package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1263_D2_D {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();

            if (!set.contains(s)) {
                for (char c : s.toCharArray()) {
                    nodes.get(c - 'a').add(i);
                }
                set.add(s);
            } else {
                visited[i] = true;
            }

        }
        for (ArrayList<Integer> list : nodes) {
            for (int i = 0; i < list.size() - 1; i++) {
                int x = list.get(i);
                int y = list.get(i + 1);
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        System.out.println(count);

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