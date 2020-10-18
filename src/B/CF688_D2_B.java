package B;

import java.util.Scanner;

public class CF688_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 3 min
        // implement time 2 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder out = new StringBuilder(s);
        System.out.println(s + out.reverse());
    }
}
