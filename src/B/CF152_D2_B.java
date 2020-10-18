package B;

import java.util.Scanner;

public class CF152_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();
        long steps = 0;
        for (int i = 0; i < k; i++) {
            int dx = scanner.nextInt();
            int dy = scanner.nextInt();

            int stepX = 0;
            int stepY = 0;
            if (dx > 0 && dy > 0) {
                stepX = (n - x) / dx;
                stepY = (m - y) / dy;
                int min = Math.min(stepX, stepY);
                x += min * dx;
                y += min * dy;
                steps += Math.abs(min);
            } else if (dx < 0 && dy < 0) {
                stepX = (1 - x) / dx;
                stepY = (1 - y) / dy;
                int min = Math.min(stepX, stepY);
                x += min * dx;
                y += min * dy;
                steps += Math.abs(min);
            } else if (dx > 0 && dy < 0) {
                stepX = (n - x) / dx;
                stepY = (1 - y) / dy;
                int min = Math.min(stepX, stepY);
                x += min * dx;
                y += min * dy;
                steps += Math.abs(min);
            } else if (dx < 0 && dy > 0) {
                stepX = (1 - x) / dx;
                stepY = (m - y) / dy;
                int min = Math.min(stepX, stepY);
                x += min * dx;
                y += min * dy;
                steps += Math.abs(min);
            } else if (dx == 0 && dy > 0) {
                stepY = (m - y) / dy;
                y += stepY * dy;
                steps += Math.abs(stepY);
            } else if (dx == 0 && dy < 0) {
                stepY = (1 - y) / dy;
                y += stepY * dy;
                steps += Math.abs(stepY);
            } else if (dx > 0) {
                stepX = (n - x) / dx;
                x += stepX * dx;
                steps += Math.abs(stepX);
            } else if (dx < 0) {
                stepX = (1 - x) / dx;
                x += stepX * dx;
                steps += Math.abs(stepX);
            }


        }
        System.out.println(steps);
    }
}
