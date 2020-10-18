package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF1237_D12_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] enter = new int[n];
        int[] exit = new int[n];
        for (int i = 0; i < n; i++) {
            enter[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            exit[i] = scanner.nextInt();
        }

        int count = 0;
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        for (i = 0, j = 0; i < n && j < n; ) {
            if (set.contains(enter[i])) {
                i++;
                continue;
            }
            if (enter[i] == exit[j]) {
                i++;
                j++;
            } else {
                set.add(exit[j]);
                j++;
                count++;
            }



        }
        System.out.println(count);
    }
}
