package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF229_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.next().toCharArray();
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            k = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '1') {
                    k = 0;
                    found = true;
                }
                ans[i][j] = Math.min(k, ans[i][j]);
                if (k < Integer.MAX_VALUE) {
                    k++;
                }
            }
            if (!found) {
                System.out.println(-1);
                return;
            }
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '1') {
                    k = 0;

                }
                ans[i][j] = Math.min(k, ans[i][j]);
                if (k < Integer.MAX_VALUE) {
                    k++;
                }
            }
        }
        k = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            k = Integer.MAX_VALUE;
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] == '1') {
                    k = 0;
                }
                ans[i][j] = Math.min(k, ans[i][j]);
                if (k < Integer.MAX_VALUE) {
                    k++;
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] == '1') {
                    k = 0;
                }
                ans[i][j] = Math.min(k, ans[i][j]);
                if (k < Integer.MAX_VALUE) {
                    k++;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(ans[i]));
//        }
        int a = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += ans[j][i];
            }
            a = Math.min(sum, a);
        }
        System.out.println(a);


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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}