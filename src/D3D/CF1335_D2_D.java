package D3D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1335_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);

    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = scanner.next();
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        int[] arr = {0, 0, 1, 3, 2, 6, 3, 1, 4, 4, 5, 7, 6, 2, 7, 5, 8, 8};
        Pair[] pairs = new Pair[9];
        for (int i = 0, j = 0; i < arr.length; j++, i += 2) {
            pairs[j] = new Pair(arr[i], arr[i + 1]);
        }
        int[] freq = new int[9];
        for (Pair value : pairs) {
            int x1 = value.x;
            int y1 = value.y;
            freq[matrix[x1][y1] - 1]++;
        }
        int change = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                change = i + 1;
            }
        }
        if (change != -1) {
            for (Pair pair : pairs) {
                int x1 = pair.x;
                int y1 = pair.y;
                matrix[x1][y1] = change;
            }
        } else {
            change = 1;
            for (Pair pair : pairs) {
                int x1 = pair.x;
                int y1 = pair.y;
                if (matrix[x1][y1] != 1)
                    matrix[x1][y1] = change;
                else
                    matrix[x1][y1] = 2;
            }
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                out.append(matrix[i][j]);
            }
            out.append('\n');
        }
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
    }
}