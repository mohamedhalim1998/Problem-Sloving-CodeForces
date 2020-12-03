package A;

import java.util.Scanner;

public class CF118_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next().toLowerCase();
        StringBuilder out = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!"aoyieu".contains("" + c)) {
                out.append('.').append(c);
            }
        }
        System.out.println(out);
    }
}
