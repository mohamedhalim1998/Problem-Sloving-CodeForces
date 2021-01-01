package B;

import java.util.Scanner;

public class CF1437_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        String s = scanner.next();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)){
              if(s.charAt(i) == '0')
                  zero++;
              else
                  one++;
            }
        }
        System.out.println(Math.max(zero, one));
    }
}
