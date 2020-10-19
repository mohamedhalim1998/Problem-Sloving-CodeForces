package B;

import java.util.HashMap;
import java.util.Scanner;

public class CF518_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();
        char[] t = scanner.next().toCharArray();
        HashMap<Character, Integer> sChars = new HashMap<>();
        HashMap<Character, Integer> tChars = new HashMap<>();
        for (char c : s) {
            sChars.put(c, sChars.getOrDefault(c, 0) + 1);
        }
        for (char c : t) {
            tChars.put(c, tChars.getOrDefault(c, 0) + 1);
        }
        int y = 0;
        for (char c : sChars.keySet()) {
            int m = Math.min(sChars.getOrDefault(c, 0), tChars.getOrDefault(c, 0));
            y += m;
            sChars.put(c, sChars.getOrDefault(c, 0) - m);
            if (tChars.containsKey(c))
                tChars.put(c, tChars.getOrDefault(c, 0) - m);
        }
        int w = 0;
        for (char c : sChars.keySet()) {
            int n = sChars.getOrDefault(c, 0);
            if (n > 0) {
                if (Character.isUpperCase(c)) {
                    int m = Math.min(sChars.getOrDefault(c, 0),
                            tChars.getOrDefault(Character.toLowerCase(c), 0));
                    w += m;
                    sChars.put(c, sChars.getOrDefault(c, 0) - m);

                } else {

                    int m = Math.min(sChars.getOrDefault(c, 0),
                            tChars.getOrDefault(Character.toUpperCase(c), 0));
                    w += m;
                    sChars.put(c, sChars.getOrDefault(c, 0) - m);

                }
            }
        }
        System.out.println(y + " " + w);


    }

}
