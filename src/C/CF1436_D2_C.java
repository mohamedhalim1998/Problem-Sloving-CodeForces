package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1436_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long[] fact = new long[1001];
        long[][] c = new long[1001][1001];
        long mod = 1000000007L;

        for (int i = 0; i <= 1000; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                if (c[i][j] >= mod) {
                    c[i][j] = c[i][j] - mod;
                }
            }
        }
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int p = scanner.nextInt();
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        int greatervalues = n - x;
        int lessvalues = x - 1;
        int countless = 0, counthighers = 0;
        int low = 0, high = n;
        while (low < high) {

            int mid = (low + high) / 2;
//            System.out.println(low+" "+mid+" "+high);
            if (mid <= p) {
                if (p != mid) {
                    countless++;
                }
                low = mid + 1;

            } else {
                counthighers++;
                high = mid;

            }

        }

        int others = n - 1 - counthighers - countless;
        long totalbig = c[greatervalues][counthighers];
        long totalsmall = c[lessvalues][countless];
        totalbig = (totalbig * fact[counthighers]) % mod;
        totalsmall = (totalsmall * fact[countless]) % mod;
        long ans = (totalbig * totalsmall) % mod;
        ans = (ans * fact[others]) % mod;
        System.out.println(ans);


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