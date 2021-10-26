package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1323_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = scanner.nextArray(n);
        int[] b = scanner.nextArray(m);
        int[] rows = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                continue;
            }

            int j = i;
            while (j < n && a[j] == 1) {
                j++;
            }
            for (int len = 1; len <= j - i; len++) {
                rows[len] += j - i - len + 1;
            }
            i = j;
        }
        int[] cols = new int[m + 1];
        for (int i = 0; i < m; i++) {
            if (b[i] == 0) {
                continue;
            }

            int j = i;
            while (j < m && b[j] == 1) {
                j++;
            }
            for (int len = 1; len <= j - i; len++) {
                cols[len] += j - i - len + 1;
            }
            i = j;
        }

        ArrayList<Pair> pairs = divisors(k);
        long count = 0;
        for (Pair p : pairs) {
            if (p.x <= n && p.y <= m)
                count += rows[p.x] * cols[p.y];
            if (p.x <= m && p.y <= n && p.x != p.y)
                count += rows[p.y] * cols[p.x];

        }
        System.out.println(count);

    }

    static ArrayList<Pair> divisors(int n) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(new Pair(i, i));
                } else {
                    list.add(new Pair(i, n / i));
                }
            }
        }
        return list;
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(pair.x, x);
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