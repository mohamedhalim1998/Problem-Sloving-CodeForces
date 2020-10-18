package B;

import java.util.Scanner;

public class CF337_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Fraction screen = new Fraction(a, b);
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        Fraction frame = new Fraction(c, d);
        Fraction blank = new Fraction(1, 1);
        if (screen.isBigger(frame)) {
            blank = blank.sub(new Fraction( b * c, a * d));
        } else {
            blank = blank.sub(new Fraction( a * d, b * c));

        }
        System.out.println(blank);
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            int gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }


        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }

        public boolean isBigger(Fraction other) {
            int lcm = lcm(other.denominator, this.denominator);
            other.numerator *= (lcm / other.denominator);
            this.numerator *= (lcm / this.denominator);
            other.denominator *= (lcm / other.denominator);
            this.denominator *= (lcm / this.denominator);
            return this.numerator > other.numerator;
        }

        public Fraction sub(Fraction other) {
            int lcm = lcm(other.denominator, this.denominator);
            other.numerator *= (lcm / other.denominator);
            this.numerator *= (lcm / this.denominator);
            other.denominator *= (lcm / other.denominator);
            this.denominator *= (lcm / this.denominator);
            return new Fraction(this.numerator - other.numerator, this.denominator);
        }
    }
}
