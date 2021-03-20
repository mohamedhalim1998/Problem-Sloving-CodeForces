package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1217_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.print(out);

    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        long s = scanner.nextInt();
        long i = scanner.nextInt();
        long e = scanner.nextInt();
        long count = 0;
        long low = 0;
        long high = e;
        long mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (s + mid > i + (e - mid)) {
                count = e - mid + 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        out.append(count).append('\n');

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