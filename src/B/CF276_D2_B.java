package B;

import java.util.HashMap;
import java.util.Scanner;

public class CF276_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int odd = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                odd++;
            }
        }

        if(odd <= 1 || odd % 2 == 1){
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }
}
