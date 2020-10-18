package B;

import java.util.Scanner;

public class CF535_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int number = 0;
        for (int i = s.length() - 1, j = 1; i >= 0; i--, j *= 2) {
            if (s.charAt(i) == '7') {
                number += (j * 2);
            } else {
                number += j;
            }
        }
        System.out.println(number);

    }
}
