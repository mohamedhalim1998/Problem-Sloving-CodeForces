package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF236_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] res = new int[a * b * c + 9];
        long sum = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    int n = i * j * k;
                    int x = n;
                    if (res[n] != 0) {
                        x = res[n];
                    } else {
                        x = divisor(n);
                        res[n] = x;
                    }
                    sum += x;
                    if (sum > 1073741824) {
                        sum = sum % 1073741824;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static int divisor(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n/i);
            }
        }
        return set.size();
    }
}
