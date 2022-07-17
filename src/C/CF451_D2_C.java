package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF451_D2_C {
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
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long d1 = scanner.nextLong();
        long d2 = scanner.nextLong();
        if (n % 3 != 0) {
            System.out.println("no");return;
        }
        boolean ans = check(d1, d2, k, n / 3);
        ans = ans || check(d1, -d2, k, n / 3);
        ans = ans || check(-d1, -d2, k, n / 3);
        ans = ans || check(-d1, d2, k, n / 3);

        if (ans) {
            out.append("yes\n");
        } else {
            out.append("no\n");
        }

    }

    static boolean check(long d1, long d2, long k, long w) {
        long a = k + 2 * d1 + d2;
        a = a / 3;
        long b = a - d1;
        long c = b - d2;
        return a <= w && b <= w && c <= w && a + b + c == k && a >= 0 && b >= 0 && c >= 0;
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
