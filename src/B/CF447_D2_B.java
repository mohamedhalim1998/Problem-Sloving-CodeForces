package B;

import java.util.HashMap;
import java.util.Scanner;

public class CF447_D2_B {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            int x = scanner.nextInt();
            map.put(alphabet[i], x);
            if (max < x) {
                max = x;
            }
        }
        long val = 0;
        int i = 1;
        for (char c : s.toCharArray()) {
            val += i * map.get(c);
            i++;
        }
        for (int j = 0; j < k; j++) {
            val += (i * max);
            i++;
        }

        System.out.println(val);

    }
}
