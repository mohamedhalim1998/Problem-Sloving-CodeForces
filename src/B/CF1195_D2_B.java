package B;

import java.util.Scanner;

public class CF1195_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        int count = 0;
        int i = 1;
        while (count - m < (n - i + 1)) {
            count += i;
            i++;
        }

        System.out.println(n - i + 1);

    }
}
