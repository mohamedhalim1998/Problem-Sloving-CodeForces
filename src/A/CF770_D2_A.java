package A;

import java.util.Scanner;

public class CF770_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for(int i = 0; i < n ; i++){
            char c = (char) (i%k + 97);
            System.out.print(c);
        }
        System.out.println();
    }
}
