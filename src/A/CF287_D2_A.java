package A;

import java.util.Scanner;

public class CF287_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 2 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        char[][] arr = new char[4][4];
        for (int i = 0; i < 4; i++) {
            arr[i] = scanner.next().toCharArray();
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4 - 1; j += 1) {
                int b = 0;
                int w = 0;
                if (arr[i - 1][j] == '#') {
                    b++;
                } else {
                    w++;
                }
                if (arr[i][j] == '#') {
                    b++;
                } else {
                    w++;
                }
                if (arr[i - 1][j + 1] == '#') {
                    b++;
                } else {
                    w++;
                }
                if (arr[i][j + 1] == '#') {
                    b++;
                } else {
                    w++;
                }

                if (b >= 3 || w >= 3) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }
}
