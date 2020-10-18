package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF807_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 1 min
        // implement time  min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = scanner.nextInt();
            next[i] = scanner.nextInt();
            if (prev[i] != next[i]) {
                System.out.println("rated");
                return;
            }
        }
        Arrays.sort(prev);
        for (int i = 0; i < n; i++) {
            if (prev[i] != next[n - i - 1]) {
                System.out.println("unrated");
                return;
            }
        }
        System.out.println("maybe");
    }
}
