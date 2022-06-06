package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF405_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.nextArray(n);
        }
        int q = scanner.nextInt();
        int res = unusualSquare(mat);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int index = scanner.nextInt() - 1;
                res = 1 - res;
            } else if (t == 2) {
                int index = scanner.nextInt() - 1;
                res = 1 - res;
            } else {
                out.append(res);
            }
        }
        System.out.println(out);


    }

    private static int unusualSquare(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[i][j] * mat[j][i];
            }
            res += sum;
        }
        return res % 2;
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
