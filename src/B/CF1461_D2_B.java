package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1461_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.next().toCharArray();
        }
        int sum = 0;
        int[][] acc = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                acc[i][j + 1] = acc[i][j];
                if (mat[i][j] == '*') {
                    acc[i][j + 1]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '*') {
                    sum++;
                    for (int k = 1; k + i < n; k++) {
                        int a = j - k, b = j + k;
                        if (a >= 0 && b < m && (acc[i + k][b + 1] - acc[i + k][a]) == 2 * k + 1) {
                            sum++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
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