package B;

import java.util.HashMap;
import java.util.Scanner;

public class CF1342_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        String t = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 0);
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.get('0') == 0 || map.get('1') == 0) {
            System.out.println(t);
            return;
        }
        int n = t.length();
        StringBuilder builder = new StringBuilder();
        if (t.charAt(0) == '1') {
            for (int i = 0; i < n; i++) {
                builder.append("10");
            }
        } else {
            for (int i = 0; i < n; i++) {
                builder.append("01");
            }
        }
        System.out.println(builder);



    }
}
