package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF893_D2_C {
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Price[] prices = new Price[n];
        for (int i = 0; i < n; i++) {
            prices[i] = new Price(i, scanner.nextInt());
        }
        Arrays.sort(prices);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] visited = new boolean[n];
        int i = 0;
        long sum = 0;
        while (i < n) {
            if (!visited[prices[i].index]) {
                dfs(prices[i].index, visited);
                sum += prices[i].price;
            }
            i++;
        }


        System.out.println(sum);
    }

    private static void dfs(int index, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.push(x);
                }
            }
        }
    }

    private static boolean spread(boolean[] visited) {
        for (boolean b : visited) {
            if (!b)
                return false;
        }
        return true;
    }

    static class Price implements Comparable<Price> {
        int index, price;

        public Price(int index, int price) {
            this.index = index;
            this.price = price;
        }

        @Override
        public int compareTo(Price o) {
            return Integer.compare(price, o.price);
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