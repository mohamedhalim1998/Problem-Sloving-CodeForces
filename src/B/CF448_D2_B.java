package B;

import java.util.Scanner;

public class CF448_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        if (s1.length() < s2.length()) {
            System.out.println("need tree");
            return;
        }
        for (char c : s2.toCharArray()) {
            if (!s1.contains("" + c)) {
                System.out.println("need tree");
                return;
            }
        }
        boolean automaton = automaton(s1, s2);
        boolean array = array(s1, s2);
        boolean both = both(s1, s2);
        if (automaton) {
            System.out.println("automaton");
        } else if (array) {
            System.out.println("array");
        } else if (both) {
            System.out.println("both");
        } else {
            System.out.println("need tree");
        }
    }

    private static boolean both(String s1, String s2) {
        for (char c : s2.toCharArray()) {
            if (countChar(s1, c) < countChar(s2, c)) {
                return false;
            }
        }
        return true;


    }

    private static boolean automaton(String s1, String s2) {
        int i = 0, j = 0;
        for (; i < s1.length() && j < s2.length(); ) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j >= s2.length();
    }

    private static boolean array(String s1, String s2) {
        if (s1.length() == s2.length()) {
            for (char c : s2.toCharArray()) {
                if (countChar(s1, c) != countChar(s2, c)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private static int countChar(String s, char c) {
        int count = 0;
        for (char c1 : s.toCharArray()) {
            if (c == c1) {
                count++;
            }
        }
        return count;
    }


}
