package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF987_D2_C {
    static  long max = 400000000000L;
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] s = scanner.nextArray(n);
        int[] p = scanner.nextArray(n);

        long min = max;
        long[] mini = new long[n];
        Arrays.fill(mini, max);
        for (int j = 1; j < n - 1; j++) {
            for (int i = 0; i < j; i++) {
                if (s[i] < s[j]) {
                    mini[j] = Math.min(mini[j], p[i]);
                }
            }
        }
        long[] mink = new long[n];
        Arrays.fill(mink, max);
        for (int j = 1; j < n - 1; j++) {
            for (int k = j; k < n; k++) {
                if (s[k] > s[j]) {
                    mink[j] = Math.min(mink[j], p[k]);
                }
            }
        }

        for (int j = 1; j < n - 1; j++) {
            min = Math.min(min, p[j] + mini[j] + mink[j]);
        }

        if (min == max) {
            System.out.println(-1);
            return;
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