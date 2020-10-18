package A;

import java.util.Scanner;

public class CF1_D12_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 1 min
        // implement time 3 min
        // debug time 2 min
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long sum = 0;
        if (m % a == 0 && n % a == 0) {
            sum = (m * n) / (a * a);
            System.out.println(sum);
            return;
        } else if ((m * n) < (a * a)) {
            System.out.println(1);
            return;
        }
        sum += Math.ceil((double) m / a) * Math.ceil((double) n / a);

        System.out.println(sum);

    }
}
