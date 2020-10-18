package A;

import java.util.Scanner;

public class CF1015_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            for (int j = l; j <= r; j++) {
                arr[j] = 1;
            }
        }
        int count = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            if (arr[i] == 0) {
                count++;
                out.append(i).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(out.toString());
    }
}
