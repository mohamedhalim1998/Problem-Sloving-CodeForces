package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF431_D2_C {
    static int n, d, k;
    static int mod = 1000000007;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        n = scanner.nextInt();
        k = scanner.nextInt();
        d = scanner.nextInt();
        int[][] dp = new int[n+2][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i <= n; ++i) {
            dp[i][0] = dp[i][1] = 0;

            for (int j = 1; j <= k; ++j) {
                if (i - j < 0) break;

                if (j < d) {
                    dp[i][0] += dp[i - j][0];
                    dp[i][0] %= mod;

                } else {
                    dp[i][1] += dp[i - j][0];
                    dp[i][1] %= mod;
                }
                dp[i][1] += dp[i - j][1];
                dp[i][1] %= mod;
            }
        }
        System.out.println(dp[n][1]);

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
