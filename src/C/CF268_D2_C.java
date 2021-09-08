package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF268_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Point> res = new ArrayList<>();
        for (int i = 0; i < Math.min(n, m) + 1; i++) {
            res.add(new Point(i, Math.min(n, m) - i));
        }

        System.out.println(res.size());
        for (Point p : res) {
            System.out.println(p);
        }

    }

    static class Point  {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean distance(Point p) {
            double dis = (y - p.y) * (y - p.y) + (x - p.x) * (x - p.x);
            dis = Math.sqrt(dis);
            int d = (int) dis;
            return (dis - d == 0.0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y ;
        }



        @Override
        public String toString() {
//            return "Point{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    ", c=" + c +
//                    '}';
            return x + " " + y;
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