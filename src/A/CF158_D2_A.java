package A;

import java.util.Scanner;

public class CF158_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt() - 1;
        int[] arr = new int[n];
        int k_score = -1;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[i] = x;
        }
        k_score = arr[k];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] >= k_score) {
                count++;
            }
        }
        System.out.println(count);
    }
}
