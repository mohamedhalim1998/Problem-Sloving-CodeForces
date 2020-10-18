package B;

import java.util.Scanner;

public class CF1030_D12_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int m = scanner.nextInt();
        Point p1 = new Point(0, d);
        Point p2 = new Point(d, 0);
        Point p3 = new Point(n, n - d);
        Point p4 = new Point(n - d, n);
        double width = distance(p1, p2);
        double height = distance(p2, p3);
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(width);

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point p = new Point(x, y);
            double d1 = distanceFromPoint(p2, p3, p);
            double d2 = distanceFromPoint(p1, p4, p);
            double d3 = distanceFromPoint(p1, p2, p);
            double d4 = distanceFromPoint(p3, p4, p);
//                System.out.println(p);
//                System.out.println(d1);
//                System.out.println(d2);
            if (((d1 - width) > .1 || (d2 - width) > .1) || ((d3 - height) > .1 || (d4 - height) > .1)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }


//                System.out.println(p);
//                System.out.println(d1);
//                System.out.println(d2);
        }

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static double distanceFromPoint(Point p1, Point p2, Point p3) {
        int a = p2.y - p1.y;
        int b = p1.x - p2.x;
        int c = a * (p1.x) + b * (p1.y);
//        if (b < 0) {
//            System.out.println(
//                    "The line passing through points P and Q is: "
//                            + a + "x - " + b + "y = " + c);
//        }
//        else {
//            System.out.println(
//                    "The line passing through points P and Q is: "
//                            + a + "x + " + b + "y = " + c);
//        }
        return Math.abs((a * p3.x + b * p3.y - c) / Math.sqrt(a * a + b * b));
    }


    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

}
