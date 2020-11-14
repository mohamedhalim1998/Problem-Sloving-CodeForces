package B;

import java.util.*;

public class CF1339_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Integer[] arr = nextArray(scanner, n);
        Arrays.sort(arr);
        StringBuilder out = new StringBuilder();
        int i = n / 2 - 1;
        int j = n / 2 - 1;
        if (n % 2 == 0) {
            j++;
        } else {
            i++;
            j++;
        }
        for (; i >= 0; i--, j++) {
            if (i == j) {
                out.append(arr[i]).append(" ");
            } else {
                out.append(arr[i]).append(" ").append(arr[j]).append(" ");
            }
        }
        System.out.println(out);

    }

    public static Integer[] nextArray(Scanner scanner, int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}