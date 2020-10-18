package A;

import java.util.HashMap;
import java.util.Scanner;

public class CF43_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 5 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String x = scanner.next();
            if (hashMap.containsKey(x)) {
                hashMap.put(x, hashMap.get(x) + 1);
            } else {
                hashMap.put(x, 1);
            }
        }
        String[] teams = new String[hashMap.keySet().size()];
        hashMap.keySet().toArray(teams);
        if (teams.length > 1) {
            if (hashMap.get(teams[0]) > hashMap.get(teams[1])) {
                System.out.println(teams[0]);
            } else {
                System.out.println(teams[1]);
            }
        } else {
            System.out.println(teams[0]);
        }
    }

}
