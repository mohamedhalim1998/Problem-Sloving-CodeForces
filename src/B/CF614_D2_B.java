package B;

import java.util.Scanner;

public class CF614_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        StringBuilder out = new StringBuilder();
        String notBeautiful = "";
        out.append(1);
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int x = -1;
            try {
                x = Integer.parseInt(s);
                if (x == 0) {
                    System.out.println("0");
                    return;
                }
            } catch (NumberFormatException e) {

            } finally {
                if (isBeautiful(s)) {
                    out.replace(0, 1, s);
                } else {
                    if (x != 1)
                        notBeautiful = s;
                }
            }
        }
        if (!notBeautiful.equals(""))
            out.replace(0, 1, notBeautiful);
        System.out.println(out);
    }

    public static boolean isBeautiful(String s) {
        return !(s.contains("2")
                || s.contains("3")
                || s.contains("4")
                || s.contains("5")
                || s.contains("6")
                || s.contains("7")
                || s.contains("8")
                || s.contains("9")
                || s.charAt(s.length() - 1) != '0'
                || moreThanOne(s));
    }

    public static boolean moreThanOne(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }
        return count > 1;
    }
}