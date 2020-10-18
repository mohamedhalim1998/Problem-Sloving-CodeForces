package B;

import java.util.Scanner;

public class CF282_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        int sumG = 0;
        int sumA = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int g = scanner.nextInt();
            if (a + sumA - sumG <= 500) {
                sumA += a;
                out.append("A");
            } else if (g + sumG - sumA <= 500){
                sumG += g;
                out.append("G");
            } else {
                System.out.println("-1");
            }
        }
        System.out.println(out.toString());
    }
}
