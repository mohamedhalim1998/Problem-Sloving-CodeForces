package B;

import java.util.Scanner;

public class CF1419_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        long x = scanner.nextLong();
        int res = 0;
        long sum = 1;
        long i = 1;
        while (x >= sum){
            res++;
            x -= sum;
            i = i + (i + 1);
            sum = i * (i + 1) / 2;

        }
        System.out.println(res);
    }

}
