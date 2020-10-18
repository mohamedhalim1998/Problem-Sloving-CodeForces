package B;

import java.util.Scanner;

public class CF148_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int v = scanner.nextInt();
        int t = scanner.nextInt();
        int f = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        if( p > v){
            System.out.println(0);
            return;
        }
        int count = 0;
        double dp = t * p;

        while (dp < c) {
            double T = (dp / (v - p));
            dp += p * T;
            if (dp >= c) {
                break;
            }
            count++;
            dp += p * (T + f);
        }
        System.out.println(count);
    }
}
