package A;

import java.util.Scanner;

public class CF474_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        String layout = "qwertyuiopasdfghjkl;zxcvbnm,./";
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        String msg = scanner.next();
        char[] out = new char[msg.length()];
        if (c == 'L') {
            int i = 0;
            for (char a : msg.toCharArray()) {
                out[i++] = layout.charAt(layout.indexOf(a) + 1);
            }
        } else {
            int i = 0;
            for (char a : msg.toCharArray()) {
                out[i++] = layout.charAt(layout.indexOf(a) - 1);
            }
        }

        System.out.println(out);
    }
}
