package A;

import java.util.Scanner;

public class CF734_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 1 min
        // implement time 4 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int anton = 0;
        int danik = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                anton++;
            } else {
                danik++;
            }
        }

        if (anton > danik) {
            System.out.println("Anton");
        } else if (danik > anton) {
            System.out.println("Danik");
        } else {
            System.out.println("Friendship");
        }
    }
}
