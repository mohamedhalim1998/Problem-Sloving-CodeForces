package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF835_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int c = scanner.nextInt();
        Point[] points = new Point[n];
        int[][][] mat = new int[11][102][102];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
            points[i].s = scanner.nextInt();
        }
        for (int i = 0; i <= c; i++) {
            for (Point p : points) {
                int x = p.x;
                int y = p.y;
                if (i > 0) {
                    mat[i][x][y] += ((p.s + i) % (c + 1));
                } else
                    mat[i][x][y] += p.s;
            }
            for (int j = 0; j <= 101; j++) {
                for (int k = 1; k <= 100; k++) {
                    mat[i][j][k] += mat[i][j][k - 1];
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt() % (c + 1);
            Point p1 = new Point(scanner.nextInt(), scanner.nextInt());
            Point p2 = new Point(scanner.nextInt(), scanner.nextInt());
            long sum = 0;

            for (int j = p1.x; j <= p2.x; j++) {
                sum += (Math.max(0, mat[t][j][p2.y] - mat[t][j][p1.y - 1]));
            }
            out.append(sum).append('\n');
        }
        System.out.println(out);

    }

    static class Point {
        int x, y, s;

        public Point(int x, int y) {
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

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}
