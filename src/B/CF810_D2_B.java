package B;

import java.util.*;

public class CF810_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 15 min
        // implement time 5 min
        // debug 10 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f = scanner.nextInt();
        long count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            int l = scanner.nextInt();
            count += Math.min(k, l);
            if (l - k > 0) {
                arr[i] = Math.min(k, l - k);
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < f; i++) {
            count += arr[n - i - 1];
        }

        System.out.println(count);
    }

}
