package B;

import java.util.Scanner;

public class CF385_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            if (s.substring(i).contains("bear")) {
                count = count + (sub.length() - sub.indexOf("bear") - 3);
            }
        }
        System.out.println(count);

    }
}
