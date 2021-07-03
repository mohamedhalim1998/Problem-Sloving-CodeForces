package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1415_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
//        int[] sums = new int[s.length() + 1];
//        for (int i = 0; i < s.length(); i++) {
//            sums[i+1] = sums[i];
//        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = '1' - s.charAt(i);
        for (int i = n - 1; i >= 0; i--) {
            if (i - k >= 0) dp[i - k] += dp[i];
        }
        long min = Integer.MAX_VALUE;
        for (int i = p - 1; i < n; i++) {
            min = Math.min(min, (i - p + 1) * y + dp[i] * x);
        }
        System.out.println(min);
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