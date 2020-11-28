package B;

import java.util.Scanner;

public class CF230_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            double sq = Math.sqrt(x);
            if (sq - Math.floor(sq) == 0) {
                if(isPrime((long) Math.floor(sq))){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }

    }

    static boolean isPrime(long m) {
        if(m == 1){
            return false;
        }
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}
