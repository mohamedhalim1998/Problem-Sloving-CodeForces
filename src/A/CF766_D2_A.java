package A;

import java.util.Scanner;

public class CF766_D2_A {
    public static void main(String[] args) {
        // time reading 1 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        if (a.equals(b))
            System.out.println(-1);
        else System.out.println(Math.max(a.length(), b.length()));
    }

    static int subsequence(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) <= s.charAt(i + 1)) {
                count++;
            } else {
                break;
            }
        }
        if (count == 0)
            return -1;
        return ++count;
    }
}
