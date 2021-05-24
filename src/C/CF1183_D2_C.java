package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1183_D2_C {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }

        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        long k = scanner.nextInt();
        long n = scanner.nextInt();
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        if (n * b >= k) {
            out.append(-1).append('\n');
        } else if (n * a < k) {
            out.append(n).append('\n');
        } else {
            long i = lessSearch(k, a, b, n);
            out.append(i).append('\n');
        }
    }

    static long lessSearch(long x, long a, long b, long n) {
        long start = 0, end = n;

        long ans = -1;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * a + (n - mid) * b >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
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