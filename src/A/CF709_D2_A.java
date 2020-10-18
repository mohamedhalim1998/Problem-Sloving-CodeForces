package A;

import java.util.Scanner;

public class CF709_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 5 min
        // implement time 4 min
        // debug 3 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int d = scanner.nextInt();
        int collection = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            if(s <= b) {
                collection += s;
            }
            if (collection > d) {
                collection = 0;
                count++;
            }
        }
        System.out.println(count);
    }
}
