package B;

import java.util.Scanner;

public class CF363_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 2 min
        // implement time 4 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] sums = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            sums[i + 1] = x + sums[i];
        }
        long min = Long.MAX_VALUE;
        int index = 1;
        for (int i = k; i < sums.length; i++) {
            long l = sums[i] - sums[i - k];
            if (l < min) {
                min = l;
                index = i;
            }

        }

        System.out.println(index - k + 1);

    }
}
