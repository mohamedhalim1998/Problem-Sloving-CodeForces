package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF489_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = nextArray(scanner, n);
        int m = scanner.nextInt();
        int[] g = nextArray(scanner, m);
        Arrays.sort(b);
        Arrays.sort(g);
        int count = 0;
        int i, j;
        boolean last = false;
        for (i = 0, j = 0; i < n && j < m; ) {
            if (Math.abs(b[i] - g[j]) <= 1) {
                if (i == n - 1 || j == m - 1) {
                    last = true;
                }
                i++;
                j++;
                count++;
            } else {
                if (b[i] > g[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        if (!last) {
            while (i < n) {
                if (Math.abs(b[i] - g[m - 1]) <= 1) {
                    count++;
                    break;
                }
                i++;
            }
            while (j < m) {
                if (Math.abs(b[n - 1] - g[j]) <= 1) {
                    count++;
                    break;
                }
                j++;
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
