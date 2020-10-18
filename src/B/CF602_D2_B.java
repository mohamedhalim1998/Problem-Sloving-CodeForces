package B;

import java.util.HashMap;
import java.util.Scanner;

public class CF602_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int currentCount = 1;
        int prevCount = 0;
        int current = arr[0];
        int prev = -1;
        int longest = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == current) {
                currentCount++;
            } else if (arr[i] == prev) {
                prevCount += currentCount;
                prev = current;
                current = arr[i];
                currentCount = 1;

            } else {
                longest = Math.max(longest, currentCount + prevCount);
                prev = current;
                prevCount = currentCount;
                current = arr[i];
                currentCount = 1;
            }
        }
        longest = Math.max(longest, currentCount + prevCount);

        System.out.println(longest);
    }
}