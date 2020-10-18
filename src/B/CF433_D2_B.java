package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF433_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 4 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stones = new int[n + 1];
        for (int i = 0; i < n; i++) {
            stones[i + 1] = scanner.nextInt();
        }
        int[] sortedStones = Arrays.copyOf(stones, n + 1);
        Arrays.sort(sortedStones);
        long[] sortedSums = new long[n + 1];
        long[] sums = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + stones[i];
            sortedSums[i] = sortedSums[i - 1] + sortedStones[i];
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int type = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (type == 1) {
                System.out.println(sums[r] - sums[l - 1]);
            } else {
                System.out.println(sortedSums[r] - sortedSums[l - 1]);

            }
        }
    }
}
