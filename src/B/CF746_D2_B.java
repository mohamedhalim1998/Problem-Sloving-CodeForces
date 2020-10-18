package B;

import java.util.Scanner;

public class CF746_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 2 min
        // implement time 4 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        boolean right = false;
        if (n % 2 == 0) {
            right = true;
        }
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (right) {
                res.insert(0, c);
                right = false;
            } else {
                res.append(c);
                right = true;
            }
        }
        System.out.println(res.toString());
    }
}
