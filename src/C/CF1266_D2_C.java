package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1266_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        if (r == 1 && c == 1) {
            System.out.println(0);
            return;
        }

        int a = 1;
        int[][] mat = new int[r][c];
        int base = 1;
        if (r == 1 || c == 1) {
            a++;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = a;
                    a++;
                }
            }
        } else {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (i + 1) * (j + 1 + r);
                    if (mat[i][j] > 1e9) {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                out.append(mat[i][j]).append(' ');
            }
            out.append('\n');
        }
        System.out.print(out);

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