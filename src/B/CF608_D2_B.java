package B;

import java.util.Scanner;

public class CF608_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        long all = 0;
        long[][] sums = new long[s2.length() + 1][2];
        for (int i = 1; i <= s2.length(); i++) {
            char c = s2.charAt(i - 1);
            if (c == '0') {
                sums[i][0] = sums[i - 1][0] + 1;
                sums[i][1] = sums[i - 1][1];
            } else {
                sums[i][1] = sums[i - 1][1] + 1;
                sums[i][0] = sums[i - 1][0];
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            for (int j = 0; j < 2; j++) {
                all += Math.abs(Character.getNumericValue(c) - j) * (sums[s2.length() - s1.length() + i + 1][j] - sums[i][j]);
            }
        }
        System.out.println(all);
    }




}

