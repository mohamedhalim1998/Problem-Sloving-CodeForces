package C;

import java.util.Scanner;

public class CF1328_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int l = scanner.nextInt();
        String s = scanner.next();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        boolean change = false;
        for (char c : s.toCharArray()) {
            if(!change) {
                if (c == '2') {
                    a.append('1');
                    b.append('1');
                } else if (c == '1') {
                    a.append('1');
                    b.append('0');
                    change = true;
                } else {
                    a.append('0');
                    b.append('0');
                }
            } else {
                a.append('0');
                b.append(c);
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}
