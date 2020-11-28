package A;

import java.util.Scanner;

public class CF445_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        char[][] ans = new char[n][m];
        boolean startW = true;
        for (int i = 0; i < n; i++) {
            if (startW) {
                startW = false;
                for (int j = 0; j < m; j += 2) {
                    ans[i][j] = 'W';
                    if (j + 1 < m) {
                        ans[i][j + 1] = 'B';
                    }
                }
            } else {
                startW = true;
                for (int j = 0; j < m; j += 2) {
                    ans[i][j] = 'B';
                    if (j + 1 < m) {
                        ans[i][j + 1] = 'W';
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    System.out.print(ans[i][j]);
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }

    }
}
