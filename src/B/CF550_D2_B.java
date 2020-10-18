package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF550_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < (1 << n); i++) {
            int b = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    b++;
                    sum += arr[j];
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                }
            }
            if (sum >= l && sum <= r && b > 1 && max - min >= x) {
                count++;
            }
        }
        System.out.println(count);
    }
}
