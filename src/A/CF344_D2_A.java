package A;

import java.util.Scanner;

public class CF344_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug  1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int groups = 1;
        int lastIn = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int currentIn = scanner.nextInt();
            if(currentIn != lastIn){
                groups++;
            }
            lastIn = currentIn;
        }
        System.out.println(groups);
    }
}
