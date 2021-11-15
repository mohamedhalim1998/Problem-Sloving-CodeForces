package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF960_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k1 = scanner.nextInt();
        int k2 = scanner.nextInt();
        long k = k1 + k2;
        int[] a = scanner.nextArray(n);
        long[] b = scanner.nextArrayLong(n);
        long e = 0;
        long[] diffs = new long[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(a[i] - b[i]);
        }
        while (k > 0) {
            Arrays.sort(diffs);
            if (diffs[n - 1] == 0) {
                break;
            }
            k -= 1;

            diffs[n - 1] -= 1;
        }
        for (long diff : diffs) {
            e += diff * diff;
        }

        System.out.println(Math.max(k % 2, e));

    }

    static class Diff implements Comparable<Diff> {
        int d, i;

        public Diff(int d, int i) {
            this.d = d;
            this.i = i;
        }

        @Override
        public int compareTo(Diff diff) {
            return Integer.compare(diff.d, d);
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