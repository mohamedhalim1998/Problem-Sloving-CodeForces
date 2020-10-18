package B;

import java.util.ArrayList;
import java.util.Scanner;

public class CF621_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[1001][1001];
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board[x][y] = 1;
            points[i] = new Point(x, y);
        }
        int count = 0;
        for (Point point : points) {
            int x = point.x;
            int y = point.y;
//            for (int i = x, j = y; i >= 1 && j >= 1; i--, j--) {
//                if (board[i][j] == 1) {
//                    count++;
//                }
//            }
            for (int i = x + 1, j = y + 1; i <= 1000 && j <= 1000; i++, j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
            for (int i = x - 1, j = y + 1; i >= 1 && j <= 1000; i--, j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
//            for (int i = x, j = y; i <= n && j >= 1; i++, j--) {
//                if (board[i][j] == 1) {
//                    count++;
//                }
//            }
        }
        System.out.println(count);

    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
