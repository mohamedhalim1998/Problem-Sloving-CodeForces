package A;

import java.util.Scanner;

public class CF334_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1, j = n * n; i < j; ) {
            StringBuilder out = new StringBuilder();
            for (int k = 0; k < n / 2; k++) {
                out.append(i++).append(" ").append(j--).append(" ");
            }
            System.out.println(out);
        }

    }
}
