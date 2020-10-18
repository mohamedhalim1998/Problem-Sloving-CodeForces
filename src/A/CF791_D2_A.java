package A;

import java.util.Scanner;

public class CF791_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int years = 0;
        while (b >= a) {
            a *= 3;
            b *= 2;
            years++;
        }
        System.out.println(years);

    }

}
