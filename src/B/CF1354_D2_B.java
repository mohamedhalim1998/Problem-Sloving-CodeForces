package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF1354_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        String s = scanner.next();
        int one = -1, two = -1, three = -1;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '1':
                    one = i;
                    break;
                case '2':
                    two = i;
                    break;
                case '3':
                    three = i;
                    break;
            }
            if (one != -1 && two != -1 && three != -1) {
                int min = Math.min(one, Math.min(two, three));
                int max = Math.max(one, Math.max(two, three));
                if (len > max - min + 1) {
                    len = max - min + 1;
                }
                if (len == 3) {
                    System.out.println(3);
                    return;
                }
            }
        }
        if (one == -1 || two == -1 || three == -1) {
            len = 0;
        }
        System.out.println(len);
    }
}
