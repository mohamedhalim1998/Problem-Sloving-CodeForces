package A;

import java.util.Scanner;

public class CF327_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        int[][] sums = new int[n + 1][2];
        int one = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                sums[i + 1][0] = sums[i][0] + 1;
                sums[i + 1][1] = sums[i][1];
            } else {
                sums[i + 1][0] = sums[i][0];
                sums[i + 1][1] = sums[i][1] + 1;
                one++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i+1; j < n + 1; j++) {
                int flip = one - (sums[j][1] - sums[i][1]) + (sums[j][0] - sums[i][0]);
                if(flip > max){
                    max = flip;
                }
            }
        }
        System.out.println(max);
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}
