package B;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CF716_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashSet<Character> set = new HashSet<>();
        int q = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        int start = -1;
        for (int i = 0; i <= s.length() -26; i++) {

            for (int j = 0; j < 26; j++) {
                if (Character.isAlphabetic(s.charAt(i + j))) {
                    set.add(s.charAt(i + j));
                } else if (s.charAt(i + j) == '?') {
                    q++;
                }
            }
            if (set.size() + q == 26) {
                start = i;
                break;
            } else {
                set = new HashSet<>();
                q = 0;
            }
        }
        if (start == -1) {
            System.out.println(-1);
        } else {
            ArrayList<Character> missing = new ArrayList<>();
            for (char c : alphabet) {
                if (!set.contains(c)) {
                    missing.add(c);
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append(s.substring(0, start).replace('?', 'A'));
            int j = 0;
            for (int i = 0; i < 26; i++) {
                if (s.charAt(start + i) == '?') {
                    builder.append(missing.get(j++));
                } else {
                    builder.append(s.charAt(start + i));
                }
            }
            builder.append(s.substring(start +26).replace('?', 'A'));
            System.out.println(builder.toString());

        }

    }
}