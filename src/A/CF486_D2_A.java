package A;

import java.util.Scanner;

public class CF486_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 2 min
        // implement time 3 min
        // debug time 2 min
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sum = 0;
        if (n % 2 == 0) {
            sum = n / 2;
        } else {
            n++;
            sum = -n / 2;

        }
        System.out.println(sum);

    }
}
