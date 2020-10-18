package A;

import java.util.Scanner;

public class CF1111_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        if (s.length() != t.length()) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            boolean sv = isVowel(s.charAt(i));
            boolean tv = isVowel(t.charAt(i));
            if(sv ^ tv){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static boolean isVowel(char c) {
        return "aeiou".contains("" + c);
    }
}
