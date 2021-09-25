package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1416_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int[] ans = new int[n + 1];
        int[] last = new int[n + 1];
        int[] f = new int[n + 1];
        Arrays.fill(ans, -1);
        for (int i = 1; i <= n; ++i) {
            int x = arr[i];
            f[x] = Math.max(f[x], i - last[x]);
            last[x] = i;
        }

        for (int x = 1; x <= n; ++x) {
            f[x] = Math.max(f[x], n - last[x] + 1);

            for (int i = f[x]; i <= n && ans[i] == -1; ++i) {
                ans[i] = x;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            out.append(ans[i]).append(' ');
        }
        System.out.println(out);

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
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
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