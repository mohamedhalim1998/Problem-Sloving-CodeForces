package A;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF219_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder out = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % n != 0) {
                System.out.println(-1);
                return;
            } else {
                 for (int i = 0; i < entry.getValue() / n; i++) {
                    out.append(entry.getKey());
                }

            }
        }
        String o = out.toString();
        for (int i = 1; i < n; i++) {
            out.append(o);
        }

        System.out.println(out);

    }
}
