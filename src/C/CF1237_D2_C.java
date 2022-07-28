package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1237_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(i + 1, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(points);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {

            Point p1 = points[i];
            Point p2 = points[i + 1];
            if (p1.removed) {
                continue;
            }
            if (p1.x == p2.x && p1.y == p2.y) {
                out.append(p1.index).append(' ').append(p2.index).append('\n');
                p1.removed = true;
                p2.removed = true;
            }
        }
        inner:
        for (int i = 0; i < n - 1; ) {
            if (points[i].removed) {
                i++;
                continue;
            }
            int j;
            for (j = i + 1; j < n; j++) {
                if (points[j].removed) continue;
                if (points[i].x == points[j].x) {
                    out.append(points[i].index).append(" ").append(points[j].index).append('\n');
//                        System.err.println((points[i].ind + 1) + " " + (points[i + 1].ind + 1));
                    points[i].removed = true;
                    points[j].removed = true;
                    i = j + 1;
                } else {
                    i = j;
                }
                continue inner;
            }
            if(j>=n){
                break inner;
            }

        }
        for (int i = 0; i < n - 1; ) {
            if (points[i].removed) {
                i++;
                continue;
            }
            int j;
            for (j = i + 1; j < n; j++) {
                if (points[j].removed) continue;

                out.append(points[i].index).append(" ").append(points[j].index).append('\n');
//                        System.err.println((points[i].ind + 1) + " " + (points[i + 1].ind + 1));
                points[i].removed = true;
                points[j].removed = true;
                i = j + 1;

                break;
            }
            if (j >= n) {
                break;
            }
        }

        System.out.print(out);

    }

    static class Point implements Comparable<Point> {
        int index;
        int x, y, z;
        boolean removed;

        public Point(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }


        @Override
        public int compareTo(Point point) {
            if (x != point.x) {
                return Integer.compare(x, point.x);
            } else if (y != point.y) {
                return Integer.compare(y, point.y);
            } else {
                return Integer.compare(z, point.z);
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