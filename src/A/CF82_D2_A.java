package A;

import java.util.Scanner;

public class CF82_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        if (n <= 5) {
            System.out.println(names[n - 1]);
            return;
        }
        int i = 5;
        int count = 1;
        while (n > 0) {
            n -= i;
            i = i * 2;
            count *= 2;
            if (n - i <= 0) {
                if (n / count == 5) {
                    System.out.println(names[4]);
                } else {
                    System.out.println(names[n / count]);
                }
                return;
            }
        }
    }
}
