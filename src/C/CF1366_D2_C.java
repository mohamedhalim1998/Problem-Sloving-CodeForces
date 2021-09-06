package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1366_D2_C {
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
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.nextArray(m);
        }
        int sx = 0;
        int sy = 0;
        int ex = n - 1;
        int ey = m - 1;
        long count = 0;
        while (sx < ex || sy < ey) {
            int z = 0;
            int o = 0;
            int y = ey;
            int x = ex;
            while (x < n && y >= 0) {
                if (mat[x][y] == 0) {
                    z++;
                } else {
                    o++;
                }
                x++;
                y--;
            }
            x = sx;
            y = sy;
            while (x < n && y >= 0) {
                if (mat[x][y] == 0) {
                    z++;
                } else {
                    o++;
                }
                x++;
                y--;
            }
            if (ex > 0) {
                ex--;
            } else {
                ey--;
            }
            if (sy < m - 1) {
                sy++;
            } else {
                sx++;
            }

            count += Math.min(z, o);
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
    }
}