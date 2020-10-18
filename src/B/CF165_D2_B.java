package B;

import java.util.Scanner;

public class CF165_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int s = 0, e = n, m = 0;
        int num = write(m, k);
        int last = num;

        while (s < e) {
            m = (s + e) / 2;
            num = write(m, k);
       //     System.out.println(m);
            if(num == n){
                break;
            }
            if (num > n) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        if(num < n){
            m++;
        }
        System.out.println(m);
    }

    private static int write(int m, int k) {
        int sum = m;
        int r = k;
        while (m / r > 0) {
            sum += m / r;
            r *= k;
        }
        return sum;
    }
}
