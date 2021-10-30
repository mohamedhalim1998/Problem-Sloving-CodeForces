package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF574_D2_B {
    static ArrayList<HashSet<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> list = dfs(visited, i);
                if (list.size() >= 3) {

                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (graph.get(j).contains(k))
                    for (int l = k + 1; l < n; l++) {

                        if (graph.get(j).contains(k) &&
                                graph.get(j).contains(l) &&
                                graph.get(l).contains(k)
                        ) {
                            int x = graph.get(j).size() + graph.get(k).size() + graph.get(l).size() - 6;
                            min = Math.min(min, x);
                            //   System.out.println(j + " " + k + " " + l + " = " + x);
                        }
                    }
            }

        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    private static ArrayList<Integer> dfs(boolean[] visited, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                list.add(curr);
            }
            visited[curr] = true;

            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.add(x);
                }
            }
        }
        return list;
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