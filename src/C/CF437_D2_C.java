package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF437_D2_C {
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Number[] numbers = new Number[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = new Number(i, scanner.nextInt());
            val[i] = numbers[i].val;
        }
        Arrays.sort(numbers);
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int sum = 0;
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) {
            int curr = numbers[i].index;
            removed[curr] = true;
            for (int x : graph.get(curr)) {
                if (!removed[x])
                    sum += val[x];
            }
        }
        System.out.println(sum);
    }

    static class Number implements Comparable<Number> {
        int index;
        int val;

        public Number(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Number number) {
            return Integer.compare(number.val, val);
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