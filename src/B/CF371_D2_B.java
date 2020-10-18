package B;

import java.util.Scanner;

public class CF371_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a == b) {
            System.out.println("0");
            return;
        }
        int count = 0;
        boolean change = true;
        int gcd = gcd(a, b);
//        System.out.println(gcd);
        a = a / gcd;
        while (a > 1 && change) {
            change = false;
            if (a % 2 == 0) {
                a = a / 2;
                change = true;
                count++;
            } else if (a % 3 == 0) {
                a = a / 3;
                change = true;
                count++;
            } else if (a % 5 == 0) {
                a = a / 5;
                change = true;
                count++;
            }
        }


        b = b / gcd;
        while (b > 1 && change) {
            change = false;
            if (b % 2 == 0) {
                b = b / 2;
                change = true;
                count++;
            } else if (b % 3 == 0) {
                b = b / 3;
                change = true;
                count++;
            } else if (b % 5 == 0) {
                b = b / 5;
                change = true;
                count++;
            }
        }
        if (a == 1 && b == 1)
            System.out.println(count);
        else
            System.out.println("-1");
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i < m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
