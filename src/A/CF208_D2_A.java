package A;

import java.util.Scanner;

public class CF208_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 1 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.replaceAll("WUB", " ").trim().replaceAll("  *", " ");
        System.out.println(s);
    }
}
