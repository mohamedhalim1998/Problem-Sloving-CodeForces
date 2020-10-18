package A;

import java.util.Scanner;

public class CF579_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int add = 1;
        while (n > 1) {
            add += n % 2;
            n = n / 2;
        }
        System.out.println(add);
    }
}
