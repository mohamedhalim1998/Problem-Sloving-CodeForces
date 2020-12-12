package B;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1406_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        Arrays.sort(arr);
        long max1 = arr[n-1] * arr[n-2] * arr[n-3] * arr[n-4] * arr[n-5];
        long max2 = arr[0] * arr[1] *  arr[n-1] * arr[n-2] * arr[n-3];
        long max3 = arr[0] * arr[1] * arr[2] * arr[3] * arr[n-1];

        long max = Math.max(max1,Math.max(max2,max3));
        System.out.println(max);
    }


}
