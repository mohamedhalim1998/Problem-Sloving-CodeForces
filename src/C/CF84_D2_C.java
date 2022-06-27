package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF84_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Circle[] circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int r = scanner.nextInt();
            circles[i] = new Circle(i, x, r);
        }
        Arrays.sort(circles);
        int m = scanner.nextInt();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point p = new Point(x, y);
            int index = lessSearch(circles, x+1);
            if (index != -1 && res[circles[index].index] == -1 && circles[index].contains(p)) {
                count++;
                res[circles[index].index] = i + 1;
            }
            index = greaterSearch(circles, x);
            if (index != -1 && res[circles[index].index] == -1 && circles[index].contains(p)) {
                count++;
                res[circles[index].index] = i + 1;
            }
        }
        System.out.println(count);
        printArrayInLine(res);

    }

    public static void printArrayInLine(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
    }

    static int lessSearch(Circle[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid].x >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    static int greaterSearch(Circle[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid].x <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }


    static class Circle implements Comparable<Circle> {
        int index, x, r;

        public Circle(int index, int x, int r) {
            this.index = index;
            this.x = x;
            this.r = r;
        }

        public Circle(int x, int r) {
            this.x = x;
            this.r = r;
        }

        public boolean contains(Point p) {
            return Math.pow(p.x - x, 2) + Math.pow(p.y, 2) <= Math.pow(r, 2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Circle circle = (Circle) o;
            return x == circle.x && r == circle.r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, r);
        }

        @Override
        public int compareTo(Circle circle) {
            return Integer.compare(x, circle.x);
        }
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