package A;

import java.util.Scanner;

public class CF1165_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String s = scanner.next();

        int count = 0;
        for (int i = s.length() - 1, j = 0; i >= 0 && j < x; i--, j++) {
            if (j == y) {
                if (s.charAt(i) != '1') {
                    count++;
                }
            } else if (s.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
