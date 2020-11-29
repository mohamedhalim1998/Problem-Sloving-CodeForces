package C;

import java.util.Arrays;
import java.util.Scanner;

public class CF285_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = nextArray(scanner, n);
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            long x =  Math.abs(i + 1 - arr[i]);
            count += x;
        }
        System.out.println(count);
    }
    public static Integer[] nextArray(Scanner scanner, int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
