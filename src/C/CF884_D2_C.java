package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF884_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt() - 1;
            graph.get(i).add(x);
            //graph.get(x).add(i);

        }
        ArrayList<Long> sizes = new ArrayList<>();
        long ans = n;
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long x = dfs(i, visited);
                sizes.add(x);
            }
        }
        Collections.sort(sizes);
        int s = sizes.size();
        if (s >= 2) {
            ans += nPr(sizes.get(s - 1) + sizes.get(s - 2), 2);
            for (int i = sizes.size() - 3; i >= 0; i--) {
                ans += nPr(sizes.get(i), 2);
            }
        } else {
            for (int i = sizes.size() - 1; i >= 0; i--) {
                ans += nPr(sizes.get(i), 2);
            }
        }
        System.out.println(ans);

    }


    static long nPr(long n, int r) {
        if (n < r) {
            return 0;
        }
        long a = 1;
        for (int i = 0; i < r; i++) {
            a *= n - i;
        }

        return a;
    }


    private static int dfs(int index, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        int size = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                size++;
            }
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.push(x);
                }
            }
        }
        return size;
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