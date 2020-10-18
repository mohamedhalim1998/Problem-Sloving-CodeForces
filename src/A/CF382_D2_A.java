package A;

import java.util.Scanner;

public class CF382_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String remain = scanner.nextLine();
        if ((s.length() + remain.length() - 1) % 2 != 0) {
            System.out.println("Impossible");
        } else {
            String[] arr = s.split("\\|");
            String right = arr.length > 1 ? s.split("\\|")[1] : "";
            String left = arr.length > 0 ? s.split("\\|")[0] : "";
            char[] chars = remain.toCharArray();
            int i = 0;
            for (char c : chars) {
                if (right.length() > left.length()) {
                    left += c;
                } else {
                    right += c;
                }
            }
            if (left.length() != right.length()) {
                System.out.println("Impossible");

            } else {
                System.out.println(left + "|" + right);
            }
        }


    }
}
