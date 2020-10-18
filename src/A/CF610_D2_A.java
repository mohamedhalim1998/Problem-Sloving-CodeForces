package A;

import java.util.Scanner;

public class CF610_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }
        n = n / 2;
        if (n % 2 == 0) {
            System.out.println(n / 2 - 1);
        } else {
            System.out.println(n / 2);
        }
    }
}
