package B;

import java.util.Scanner;

public class CF552_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = String.valueOf(n).length();
        long c = 1;
        long sum = 0;
        int rem = n;
        for (int i = 0; i < l - 1; i++) {
            int count = (int) (9 * Math.pow(10, i));
            rem -= count;
            sum += count * c;
            c++;
        }
        sum += rem * c;

        System.out.println(sum);
    }
}
