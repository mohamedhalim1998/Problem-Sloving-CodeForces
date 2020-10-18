package A;

import java.util.Scanner;

public class CF804_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cost = (n +1)/ 2 - 1;
        if (n < 2) {
            System.out.println(0);
        } else {
            System.out.println(cost);
        }

    }
}
