package C;

import java.util.Scanner;

public class CF344_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long sum = 0;
        while (b > 0) {
            long div = a / b;
            if (a % b == 0) {
                sum += div;
                break;
            }
            long temp = b;
            b = a - div * b;
            sum += div;
            a = temp;
        }
        System.out.println(sum);
    }

}
