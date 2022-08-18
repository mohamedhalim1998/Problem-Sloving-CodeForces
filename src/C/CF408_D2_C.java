package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF408_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        HashSet<Point> setA = new HashSet<>();
        HashSet<Point> setB = new HashSet<>();
        for (int i = -a; i <= a; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = -a; j <= a; j++) {
                if (j == 0) {
                    continue;
                }
                if (i * i + j * j == a * a) {
                    setA.add(new Point(i, j));
                }
            }
        }
        for (int i = -b; i <= b; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = -b; j <= b; j++) {
                if (j == 0) {
                    continue;
                }
                if (i * i + j * j == b * b) {
                    setB.add(new Point(i, j));
                }
            }
        }
        for (Point p1 : setA) {
            for (Point p2 : setB) {
                double angle =  (Math.atan2(p2.y, p2.x) * (180 / Math.PI));
                double angle2 = (Math.atan2(p1.y, p1.x) * (180 / Math.PI));
                if (angle < 0) {
                    angle += 360;
                }
                if (angle2 < 0) {
                    angle2 += 360;
                }

                if (Math.abs(angle - angle2) == 90.0 && p2.y != p1.y && p2.x != p1.x) {
                    System.out.println("YES");
                    System.out.println("0 0");
                    System.out.println(p1);
                    System.out.println(p2);
                    return;
                }
            }
        }
        System.out.println("NO");


    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private static HashSet<Integer> divisor(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        set.add(n);
        return set;
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