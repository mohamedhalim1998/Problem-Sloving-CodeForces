package A;

import java.util.Scanner;

public class CF365_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (checkNum(x, k)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean checkNum(int n, int max) {
        String s = "" + n;
        for (int i = 0; i <= max; i++) {
            if (!s.contains(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }
}
