package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF1294_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(points);
        StringBuilder path = new StringBuilder();
        goToPoint(new Point(0, 0), points[0], path);
        Point current = points[0];
        for (int i = 1; i < n; i++) {
            if (current.y > points[i].y) {
                System.out.println("NO");
                return;
            } else {
                goToPoint(points[i - 1], points[i], path);
                current.x = Math.max(current.x, points[i].x);
                current.y = Math.max(current.y, points[i].y);
            }
        }
        System.out.println("YES");
        System.out.println(path);
//        StringBuilder out = new StringBuilder();
//        for (int j = 0; j < x[0]; j++) {
//            out.append('R');
//        }
//        for (int j = 0; j < y[0]; j++) {
//            out.append('U');
//        }
//        for (int i = 1; i < n; i++) {
//            if (x[i] > x[i - 1]) {
//                for (int j = 0; j < x[i] - x[i - 1]; j++) {
//                    out.append('R');
//                }
//            } else if (x[i] <)
//                if (y[i] > y[i - 1])
//                    for (int j = 0; j < y[i] - y[i - 1]; j++) {
//                        out.append('U');
//                    }
//        }
//        System.out.println("YES");
//        System.out.println(out);
    }

    private static void goToPoint(Point from, Point to, StringBuilder path) {
        for (int i = 0; i < to.x - from.x; i++) {
            path.append('R');
        }
        for (int i = 0; i < to.y - from.y; i++) {
            path.append('U');
        }
    }

    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (point.x != x) {
                return Integer.compare(x, point.x);
            } else {
                return Integer.compare(y, point.y);
            }
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)" , x , y);
        }
    }
}
