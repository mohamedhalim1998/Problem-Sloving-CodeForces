package B;

import java.util.Scanner;

public class CF287_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        if(n == 1){
            System.out.println(0);
            return;
        }
        if (n <= k) {
            System.out.println(1);
            return;
        }
        long sum = k * (k - 1) / 2;
        if (sum < n - 1) {
            System.out.println("-1");
            return;
        }
        long s = 2, e = k;
        n--;
        while (s < e) {
            long m = (s + e) / 2;
            long sum2 = sum - (m * (m - 1) / 2);
          //  System.out.println(sum2);
            if (sum2 > n - 1) {
                s = m + 1;
            } else {
                e = m;
            }
        }


        System.out.println(k - s + 1);

    }


}
