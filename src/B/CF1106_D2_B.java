package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1106_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Dish[] arr = new Dish[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Dish(i);
        }
        for (int i = 0; i < n; i++) {
            arr[i].r = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i].c = scanner.nextInt();
        }
        Dish[] sorted = new Dish[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = new Dish(arr[i]);
        }
        Arrays.sort(sorted);
        int j = 0;

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt() - 1;
            int d = scanner.nextInt();
            long c = 0;
            long min = Math.min(arr[t].r, d);
            arr[t].r -= min;
            d -= min;
            c += min * arr[t].c;
            while (d > 0 && j < n) {
                int index = sorted[j].index;
                min = Math.min(arr[index].r, d);
                arr[index].r -= min;
                d -= min;
                c += min * arr[index].c;
                if (d > 0) {
                    j++;
                }
            }
            if(d == 0) {
                out.append(c).append('\n');
            } else {
                out.append(0).append('\n');
            }
        }
        System.out.println(out);

    }

    static class Dish implements Comparable<Dish> {
        int index;
        long r, c;

        public Dish(int index) {
            this.index = index;
        }

        public Dish(Dish d) {
            this.index = d.index;
            this.r = d.r;
            this.c = d.c;
        }

        @Override
        public int compareTo(Dish dish) {
            if (c != dish.c) {
                return Long.compare(c, dish.c);
            } else {
                return Integer.compare(index, dish.index);
            }
        }

        @Override
        public String toString() {
            return "Dish{" +
                    "index=" + index +
                    ", r=" + r +
                    ", c=" + c +
                    '}';
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