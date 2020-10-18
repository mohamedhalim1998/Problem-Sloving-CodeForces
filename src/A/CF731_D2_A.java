package A;

import java.util.Scanner;

public class CF731_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 10 min
        // implement time 4 min
        // debug time 10 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int sum = 0;
        int index = 97;
        for (char c : s.toCharArray()) {
            int diff = Math.abs(c - index);
            diff = Math.min(diff, (26 - diff));
            sum += diff;
            index = c;
        }
        System.out.println(sum);
    }
}
