package A;

import java.util.Scanner;

public class CF1364_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + arr[i];
        }
        int max = 0;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] % x != 0) {
                max = i;
                break;
            }
        }
        for (int i = 0; i < sums.length - 1; i++) {
            if((sums[n] - sums[i] ) % x != 0){
                if(n- i > max){
                    max = n - i;
                    break;
                }
            }
        }
        if(max > 0) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}
