package A;

import java.util.HashMap;
import java.util.Scanner;

public class CF136_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 2 min
        // implement time 3 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hashMap.put(scanner.nextInt(),i);
        }
        System.out.print(hashMap.get(1));
        for (int i = 2; i <= n; i++) {
            System.out.print(" " + hashMap.get(i));
        }
        System.out.println();
    }
}
