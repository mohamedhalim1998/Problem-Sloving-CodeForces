package C;

import java.util.Arrays;
import java.util.Scanner;

public class CF699_D2_C {
    static int n;
//    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        int[][] res = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                res[i][j] = -1;
            }
        }
// r == 0 , g == 1 , c == 2
        int count = calculateRes(res, arr, 0, 0);
//        System.out.println(Arrays.toString(res));
        System.out.println(count);
    }

    private static int calculateRes(int[][] res, int[] arr, int i, int prev) {
        if (i == n) {
            return 0;
        }
        int x = res[i][prev];
        if (x != -1) {
            return x;
        }
        x = Integer.MAX_VALUE;
        switch (arr[i]) {
            case 0:
                x = 1 + calculateRes(res, arr, i + 1, 0);
                break;
            case 1:
                if (prev != 2)
                    x = calculateRes(res, arr, i + 1, 2);
                else
                    x = 1 + calculateRes(res, arr, i + 1, 0);
                break;
            case 3:
                if (prev != 2)
                    x = calculateRes(res, arr, i + 1, 2);
                if (prev != 1)
                    x = Math.min(x, calculateRes(res, arr, i + 1, 1));
                break;
            case 2:
                if (prev != 1)
                    x = calculateRes(res, arr, i + 1, 1);
                else
                    x = 1 + calculateRes(res, arr, i + 1, 0);
                break;
        }
        res[i][prev] = x;


        return x;
    }

}
