package C;

import java.util.ArrayList;
import java.util.Scanner;

public class CF353_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        String x = scanner.next();
        long ans = 0;
        long[] sums = new long[n + 9];
        long[] sumsOrigin = new long[n + 9];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + arr[i - 1];
        }
        for (int i = n + 1; i < sums.length; i++) {
            sums[i] = sums[i - 1];
        }

        ArrayList<Integer> ones = new ArrayList<>();
        for (int i = 0; i < x.length(); i++) {
            sumsOrigin[i + 1] = sumsOrigin[i];
            if (x.charAt(i) == '1') {
                ones.add(i);
                ans += arr[i];
                sumsOrigin[i + 1] += arr[i];
            }
        }

        for (int o : ones) {
            long s = sums[o];
            s += sumsOrigin[n] - sumsOrigin[o + 1];
            if (s > ans) {
                ans = s;
            }
        }
        System.out.println(ans);

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
