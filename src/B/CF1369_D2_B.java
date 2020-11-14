package B;

import java.util.Scanner;

public class CF1369_D2_B {
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
        if(isClean(s)){
            System.out.println(s);
            return;
        }
        int zero = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                break;
            }
        }
        int one = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                break;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < zero; i++) {
            out.append(0);
        }
        for (int i = 0; i < one; i++) {
            out.append(1);
        }

        System.out.println(out);
    }

    private static boolean isClean(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) > s.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }

}
