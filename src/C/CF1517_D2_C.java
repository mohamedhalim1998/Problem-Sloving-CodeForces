package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1517_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            grid[i][i] = x;

        }
        for (int i = 0; i <n; i++) {
            int x = grid[i][i];
            int c = x ;
            int row = i;
            int col = i;
            while (c > 0) {
                if (col < 0) {
                    col = 0;
                    row++;
                }
                if (grid[row][col] == 0 || grid[row][col] == x) {
                    c--;
                    grid[row][col] = x;
                    col--;
                } else {
                    row++;
                    col++;
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                out.append(grid[i][j]).append(" ");
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