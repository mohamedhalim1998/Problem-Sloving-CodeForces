package A;

import java.util.Scanner;

public class CF225_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 3 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int top = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int side1 = scanner.nextInt();
            int side2 = scanner.nextInt();
            if (top == side1 || top == side2 ||
                    7 - top == side1 || 7 - top == side2 ||
                    7 - top == 7 - side1 || 7 - top == 7 - side2 ||
                    top == 7 - side1 || top == 7 - side2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
