package B;

import java.util.Scanner;

public class CF570_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n == 1 && m == 1){
            System.out.println(1);
            return;
        }
        int a1 = m + 1;
        int a2 = m - 1;
        if (n - a1 > a2 - 1) {
            System.out.println(a1);
        } else {
            System.out.println(a2);
        }
    }
}
