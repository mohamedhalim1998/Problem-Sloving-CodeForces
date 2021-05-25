package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1228_D2_B {
    static long mod = 1000000007;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        int[] rows = scanner.nextArray(n);
        int[] cols = scanner.nextArray(m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rows[i]; j++) {
                grid[i][j] = 1;
            }
            if (rows[i] < m) {

                grid[i][rows[i]] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < cols[i]; j++) {
                if (grid[j][i] != -1) {
                    grid[j][i] = 1;
                } else {
                    System.out.println(0);
                    return;
                }
            }

            if (cols[i] < n) {
                if (grid[cols[i]][i] != 1) {
                    grid[cols[i]][i] = -1;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        long count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    count *= 2;
                    count = count % mod;
                }
            }
        }
        System.out.println(count);
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