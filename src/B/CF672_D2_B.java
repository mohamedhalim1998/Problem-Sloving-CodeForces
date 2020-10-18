package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF672_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        if (s.length() > 26) {
            System.out.println("-1");
        } else {
            int count = 0;
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    count++;
                } else {
                    set.add(c);
                }
            }
            System.out.println(count);
        }
    }
}
