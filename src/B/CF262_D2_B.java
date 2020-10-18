package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF262_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] income = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            income[i] = scanner.nextInt();
        }
        int i = 0;
        while (i < n && income[i] < 0 && k > 0) {
            k--;
            income[i] *= -1;
            i++;
        }
        if (k == 0) {
            System.out.println(sum(income));
        } else {
            Arrays.sort(income);
            if (k % 2 == 0) {
                System.out.println(sum(income));
            } else {
                income[0] = -income[0];
                System.out.println(sum(income));
            }
        }
    }

    private static long sum(int[] income) {
        long sum = 0;
        for (int i = 0; i < income.length; i++) {
            sum += income[i];
        }
        return sum;
    }
}
