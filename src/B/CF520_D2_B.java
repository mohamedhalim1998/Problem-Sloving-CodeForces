package B;

import java.util.Scanner;

public class CF520_D2_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solve(n, m));
    }

    static int solve(int n, int m) {
        int count = 0;
        while (n != m) {
           count++;
           if(m > n && m%2 == 0){
               m = m / 2;
           } else {
               m++;
           }
        }
        return count;

    }
}
