package A;

import java.util.Scanner;

public class CF3_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();
        char[] e = scanner.next().toCharArray();
        StringBuilder out = new StringBuilder();
        int count = 0;
        while (s[0] != e[0] || s[1] != e[1]) {
            count++;
            if (s[0] > e[0]) {
                s[0]--;
                out.append("L");
            } else if (s[0] < e[0]) {
                s[0]++;
                out.append("R");
            }
            if (s[1] > e[1]) {
                s[1]--;
                out.append("D");
            } else if (s[1] < e[1]) {
                s[1]++;
                out.append("U");
            }
            out.append("\n");
        }
        System.out.println(count);
        System.out.println(out);
    }
}
