package B;

import java.util.Scanner;

public class CF1009_D12_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ones = 0;
        int first = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        s = s.replace("1", "");
        StringBuilder out = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '2') {
                first = i;
                break;
            }
        }
        StringBuilder one = new StringBuilder();
        for (int i = 0; i < ones; i++) {
            one.append(1);
        }
        if (first == -1) {
            out.append(one.toString());
        } else {
            out.insert(first, one.toString());
        }

        System.out.println(out.toString());
    }
}
