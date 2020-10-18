package A;

import java.util.HashMap;
import java.util.Scanner;

public class CF296_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        if(n % 2 != 0){
            n++;
        }
        for (Integer i : map.keySet()) {
            if(map.get(i) > n/2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
