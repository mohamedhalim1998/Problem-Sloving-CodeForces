package B;

import java.util.Scanner;

public class CF1375_D2_B {
    static int[] neighbors = {0, 1,
            0, -1,
            1, 0,
            -1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        boolean isGood = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = scanner.nextInt();
                grid[i][j] = x;
                if (x != 0) {
                    isGood = false;
                }
            }
        }
        if (isGood) {
            System.out.println("YES");
            print2DArray(grid);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    boolean done = editNeighbors(i, j, grid[i][j], grid);
                    if (!done) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] != 0){
                    balanceNeighbors(i , j , grid[i][j], grid);
                }
            }
        }
        System.out.println("YES");
        print2DArray(grid);
    }

    private static void balanceNeighbors(int i, int j, int n, int[][] grid) {
        int count = 0;
        for (int k = 0; k < neighbors.length; k += 2) {
            int x = i + neighbors[k];
            int y = j + neighbors[k + 1];
            if (isValid(x, y, grid.length, grid[0].length)) {
                if (grid[x][y] != 0) {
                    count++;
                }
            }
        }
        if(count > n){
            grid[i][j] = count;
        }
    }

    private static boolean editNeighbors(int i, int j, int n, int[][] grid) {
        int count = 0;
        for (int k = 0; k < neighbors.length; k += 2) {
            int x = i + neighbors[k];
            int y = j + neighbors[k + 1];
            if (isValid(x, y, grid.length, grid[0].length)) {
                if (grid[x][y] != 0) {
                    count++;
                }
            }
        }
        if(count > n){
            grid[i][j] = count;
            return true;
        }
        if (count == n) {
            return true;
        } else {
            for (int k = 0; k < neighbors.length; k += 2) {
                int x = i + neighbors[k];
                int y = j + neighbors[k + 1];
                if (isValid(x, y, grid.length, grid[0].length)) {
                    if (grid[x][y] == 0) {
                        grid[x][y] = 1;
                        count++;
                    }
                    if(count == n){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static void print2DArray(int[][] grid) {
        for (int[] arr : grid) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
