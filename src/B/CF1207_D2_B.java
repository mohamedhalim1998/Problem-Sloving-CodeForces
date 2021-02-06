package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1207_D2_B {
    private static int m;
    private static int n;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int[][] b = new int[n][m];
        int[][] sub = {
                new int[]{0, 0, 0, 1, 1, 1, 1, 0},
                new int[]{-1, 0, 0, 1, -1, 0, -1, 1},
                new int[]{0, -1, 1, -1, 1, 0, 0, -1},
                new int[]{-1, -1, -1, -1, -1, 0, 0, -1}};
        int count = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && b[i][j] != 1) {
                    for (int[] arr : sub) {
                        boolean convert = true;
                        for (int k = 2; k < arr.length; k += 2) {
                            int x = i + arr[k];
                            int y = j + arr[k + 1];
                            if (!valid(x, y) || a[x][y] != 1) {
                                convert = false;
                                break;
                            }
                        }
                        if (convert) {
                            b[i][j] = 1;
                            for (int k = 2; k < arr.length; k += 2) {
                                int x = i + arr[k];
                                int y = j + arr[k + 1];
                                b[x][y] = 1;
                            }
                            count++;
                            out.append(i + arr[0] + 1).append(' ').append(j + arr[1] + 1).append('\n');
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
        System.out.println(out);
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
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