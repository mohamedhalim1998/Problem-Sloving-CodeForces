package A;

import java.util.Scanner;

public class CF677_D2_A {

    public static void main(String[] args) {
        // time reading 3 min
        // think 1 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int minWidth = 0;
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            if(height > h){
                minWidth += 2;
            } else {
                minWidth++;
            }
        }

        System.out.println(minWidth);
    }
}
