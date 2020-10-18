package A;

import java.util.Scanner;

public class CF289_D2_A {
    public static void main(String[] args) {
        // time reading 5 min
        // think 1 min
        // implement time 6 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            sum += (y - x + 1);
        }
        if (sum % k == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(k - (sum % k));

    }
}
