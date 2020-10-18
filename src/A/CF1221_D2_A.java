package A;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1221_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] arr = new int[12];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x <= 2048) {
                int log = log2(x);
                arr[log] = arr[log] + 1;
            }
        }
        if (arr[11] >= 1) {
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                arr[i + 1]++;
            }
        }
        if (arr[11] >= 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



    }

    public static int log2(int N) {

        return (int) (Math.log(N) / Math.log(2));
    }
}
