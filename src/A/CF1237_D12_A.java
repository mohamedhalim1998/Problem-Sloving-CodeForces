package A;

import java.util.Scanner;

public class CF1237_D12_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int margin = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x % 2 == 0) {
                System.out.println(x / 2);
            } else {
                if (margin == 0) {
                    System.out.println(x / 2);
                    if (x > 0) {
                        margin--;
                    } else {
                        margin++;
                    }
                } else if (margin > 0) {
                    if (x > 0) {
                        System.out.println(x / 2);
                        margin--;
                    } else {
                        System.out.println(x / 2 - 1);
                        margin--;
                    }
                } else {
                    if (x > 0) {
                        System.out.println(x / 2 + 1);
                        margin++;
                    } else {
                        System.out.println(x / 2);
                        margin++;
                    }
                }
            }
        }
    }
}
