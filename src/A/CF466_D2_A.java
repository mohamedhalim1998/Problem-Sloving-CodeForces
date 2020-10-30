package A;

import java.util.Scanner;

public class CF466_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int count = b * (n / m) + (n % m) * a;
        count = Math.min(count, n * a);
        count = Math.min(count, b * ((n / m) + 1));
        System.out.println(count);
    }
}
