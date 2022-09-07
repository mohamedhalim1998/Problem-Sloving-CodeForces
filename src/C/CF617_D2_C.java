package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF617_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Point f1 = new Point(scanner.nextInt(), scanner.nextInt());
        Point f2 = new Point(scanner.nextInt(), scanner.nextInt());
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        long min = Long.MAX_VALUE;
        long[] dist1 = new long[n];
        long[] dist2 = new long[n];
        for (int i = 0; i < n; i++) {
            dist1[i] = f1.dist(arr[i]);
            dist2[i] = f2.dist(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            long r1 = dist1[i];
            long r2 = 0;
            for (int j = 0; j < n; j++) {
                if (dist1[j] > r1) {
                    r2 = Math.max(r2, dist2[j]);
                }
            }
            min = Math.min(min, r1 + r2);
        }
        for (int i = 0; i < n; i++) {
            long r1 = 0;
            long r2 = dist2[i];
            for (int j = 0; j < n; j++) {
                if (dist2[j] > r2) {
                    r1 = Math.max(r1, dist1[j]);
                }
            }
            min = Math.min(min, r1 + r2);
        }


        System.out.println(min);


    }

    private static boolean inside(Point point, Point f, long r) {
        return point.dist(f) <= r;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public long dist(Point other) {
            long dy = y - other.y;
            long dx = x - other.x;
            return dy * dy + dx * dx;
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