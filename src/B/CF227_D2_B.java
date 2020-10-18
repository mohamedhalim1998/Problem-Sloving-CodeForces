package B;

import java.util.HashMap;
import java.util.Scanner;

public class CF227_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 2 min
        // implement time 3 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scanner.nextInt(), i);
        }
        int m = scanner.nextInt();
        long vasya = 0;
        long petya = 0;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            vasya += map.get(x) + 1;
            petya += n - map.get(x);
        }
        System.out.println(vasya + " " + petya);
    }
}
