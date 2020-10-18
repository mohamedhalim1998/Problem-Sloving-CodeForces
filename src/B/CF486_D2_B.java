package B;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CF486_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = scanner.nextInt();
                matrix[i][j] = x;
                if (x == 1)
                    pairs.add(new Pair(i, j));
            }
        }
        int[][] a = new int[n][m];
        boolean one = false;
        if(pairs.size() == 0){
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        for (Pair pair : pairs) {
            int res = check(pair, matrix);
                switch (res){
                    case 0:
                        System.out.println("NO");
                        return;
                    case 2:
                        a[pair.x][pair.y] = 1;
                        one = true;
                        break;
                }
        }
        if(one) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int check(Pair pair, int[][] matrix) {
        int res = 2;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][pair.y] == 0) {
                res--;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[pair.x][j] == 0) {
                res--;
                break;
            }
        }
        return res;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
