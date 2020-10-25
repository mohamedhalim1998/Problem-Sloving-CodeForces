package B;

import java.util.Scanner;

public class CF1366_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        long s = scanner.nextLong();
        long d = scanner.nextLong();
        long sum = s + d;
        if(s < d){
            System.out.println(Math.min(sum / 3 , s));
        } else {
            System.out.println(Math.min(sum / 3 , d));
        }
    }
}
