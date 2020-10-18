package A;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF469_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < line.length; i++) {
            int x = Integer.parseInt(line[i]);
            if (x != 0)
                set.add(x);
        }

        for (int i = 1; i < line2.length; i++) {
            int x = Integer.parseInt(line2[i]);
            if (x != 0)
                set.add(x);
        }
        String out = set.size() == n ? ("I become the guy.") : ("Oh, my keyboard!");
        System.out.println(out);
    }
}
