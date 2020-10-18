package A;

import java.util.Scanner;

public class CF270_D2_A {
    public static void main(String[] args) {
        // reading time 1 min
        // think time 5 min
        // implement time 4 min
        // debug time 1 min
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            if(check(scanner.nextInt())){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }

    private static boolean check(int alpha) {
        double n = (360d / (180.0 - alpha));
       // System.out.println(n);
        return n == (int) n;
    }
}
