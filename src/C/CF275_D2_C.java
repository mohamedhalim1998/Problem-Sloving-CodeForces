package C;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF275_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        
        HashSet<Long> set = new HashSet<>();
        Arrays.sort(arr);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            long x = arr[i] * k;
            if (!set.contains(x)) {
                set.add((long) arr[i]);
                count++;
            }
        }
        System.out.println(count);
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
