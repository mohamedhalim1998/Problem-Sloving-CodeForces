package B;

import java.util.Scanner;

public class CF544_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 1 || k == 0) {
                        map[i][j] = 'S';
                    } else if (k > 0) {
                        map[i][j] = 'L';
                        k--;
                    }
                } else {
                    if (j % 2 == 0 || k == 0) {
                        map[i][j] = 'S';
                    } else if (k > 0) {
                        map[i][j] = 'L';
                        k--;
                    }
                }
            }
        }
        if (k == 0) {
            printMap(map);
        } else {
            System.out.println("NO");
        }


    }

    static void printMap(char[][] map) {
        System.out.println("YES");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
