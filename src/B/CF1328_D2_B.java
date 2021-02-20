package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1328_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        long n = scanner.nextInt();
        long m = n;
        long x = scanner.nextInt();
        x = (n * (n - 1)) / 2 - x + 1;
        int c = 0;
        n = n - 1;
        while (x > n) {
            c++;
            x -= n;
            n--;
        }
        for (int i = 0; i < c; i++) {
            out.append('a');
        }
        m -= c;
        out.append('b');
        long min = Math.min(n, x);
        for (int i = 0; i < min - 1; i++) {
            out.append('a');
        }
        m -= min;
        out.append('b');
        for (int i = 0; i < m -1; i++) {
            out.append('a');
        }
        out.append('\n');
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