package A;

import java.util.Scanner;

public class CF404_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 2 min
        // implement time 5 min
        // debug 5 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(scanner.next());
        }
        String s = builder.toString();
        boolean x = true;
        if (s.charAt(0) == s.charAt(1)) {
            System.out.println("NO");
            return;
        }
        char other = s.charAt(1);
        for (int i = 1, j = n + 1, k = n - 1; i < s.length(); i++) {
            if (i == j && i == k) {
                j = j + n + 1;
                k = k + n - 1;
                continue;
            }
            if (i == j) {
                j = j + n + 1;
                continue;
            }
            if (i == k) {
                k = k + n - 1;
                continue;
            }
            if (s.charAt(i) != other) {
                x = false;
                break;
            }
        }

        for (int i = 0, j = n - 1; i < s.length(); i++, j--) {
            if ((s.charAt(i) != s.charAt(j)) || (s.charAt(0) != s.charAt(j)) || (s.charAt(i) != s.charAt(0))) {
                x = false;
                break;
            } else {
                i += n;
                j += n;
            }
        }
        if (x) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
