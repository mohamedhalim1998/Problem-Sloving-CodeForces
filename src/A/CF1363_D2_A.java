package A;

import java.util.Scanner;

public class CF1363_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (odd == 0) {
            System.out.println("NO");
            return;
        }
        if(x % 2 ==0){
            if(even == 0){
                System.out.println("NO");
                return;
            }
        }
        if (odd % 2 == 0) {
            if (x - odd + 1 - even > 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } else {
            if (x - odd - even > 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
