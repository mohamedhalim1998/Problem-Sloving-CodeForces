package A;

import java.util.*;

public class CF405_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 7 min
        // implement time 4 min
        // debug  2 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        Collections.sort(arr);
        System.out.print(arr.get(0));
        for (int i = 1; i < n; i++) {
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }
}
