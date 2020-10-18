package A;

import java.util.HashSet;
import java.util.Scanner;

public class CF228_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time  2 min
        // implement time 2 min
        // debug time 0 min
        HashSet<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            set.add(scanner.nextInt());
        }

        System.out.println(4 - set.size());



    }
}
