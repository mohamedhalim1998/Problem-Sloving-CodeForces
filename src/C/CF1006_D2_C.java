package C;

import java.util.ArrayList;
import java.util.Scanner;

public class CF1006_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = nextArray(scanner, n);
        long sum1 = 0;
        long sum3 = 0;
        int i = -1;
        int j = n;
        long max = 0;
        while (i < j) {
            if (sum1 == sum3) {
                max = sum1;
            }
            if (sum1 < sum3) {
                i += 1;
                sum1 += a[i];
            } else {
                j -= 1;
                sum3 += a[j];
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
