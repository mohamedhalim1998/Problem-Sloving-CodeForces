package A;

import java.util.Scanner;

public class CF1253_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (diff == 0) {
                diff = b[i] - a[i];
                a[i] = a[i] + diff;

            } else {
                if (a[i] + diff != b[i]) {
                    break;
                } else {
                    a[i] = a[i] + diff;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(a[i] != b[i]){
                System.out.println("NO");
                return;
            }
        }
        if (diff >= 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
