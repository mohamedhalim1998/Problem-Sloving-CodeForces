package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1103_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int[][] grid = new int[4][4];
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                L1:
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[j][k] == 0 && grid[j + 1][k] == 0) {
                            out.append(j + 1).append(' ').append(k + 1).append('\n');
                            grid[j][k] = 1;
                            grid[j + 1][k] = 1;
                            break L1;
                        }
                    }
                }
            } else {
                L1:
                for (int j = 3; j >= 0; j--) {
                    for (int k = 0; k < 3; k++) {
                        if (grid[j][k] == 0 && grid[j][k + 1] == 0) {
                            out.append(j + 1).append(' ').append(k + 1).append('\n');
                            grid[j][k] = 1;
                            grid[j][k + 1] = 1;
                            break L1;
                        }

                    }
                }
            }
            checkFill(grid);
        }
        System.out.print(out);

    }

    private static void checkFill(int[][] grid) {
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
            if (count == 4) {
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = 0;
                }
            }
        }
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