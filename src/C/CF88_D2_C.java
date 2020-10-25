package C;

import java.util.Scanner;

public class CF88_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long d = 0;
        long m = 0;
        long lcm = lcm(a, b);
        long l = 0;
        long r = 0;
        for (; r <= lcm; ) {
            if (rem(r, a) < rem(r, b)) {
                l = r;
                if (r % a == 0) {
                    r -= a;
                }
                if (r < a) {
                    r = a;
                } else {
                    r = (r / a + 1) * a;
                }
                d += r - l + 1;
                if (l == 0) {
                    d--;
                }
                r++;
            } else if (rem(r, a) > rem(r, b)) {
                l = r;
                if (r % b == 0) {
                    r -= b;
                }
                if (r < b) {
                    r = b;
                } else {
                    r = (r / b + 1) * b;
                }
                m += r - l + 1;
                if (l == 0) {
                    m--;
                }
                r++;
            } else {
                if (a > b) {
                    d += lcm - r + 1;
                } else {
                    m += lcm - r + 1;
                }
                break;
            }
        }

//        if (g1) {
//            d += r - l;
//        } else {
//            m += r - l;
//        }

        if (d > m) {
            System.out.println("Dasha");
        } else if (m > d) {
            System.out.println("Masha");
        } else {
            System.out.println("Equal");
        }
    }

    private static long rem(long i, int n) {
        if (i != 0 && i % n == 0) {
            return 0;
        }
        return n - (i % n);
    }

    static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
