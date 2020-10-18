package A;

import java.util.Scanner;

public class CF231_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 10 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sol = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if((a == 1 && b == 1) || (a == 1 && c == 1) || (c == 1 && b == 1)){
                sol++;
            }
        }

        System.out.println(sol);

    }
}
