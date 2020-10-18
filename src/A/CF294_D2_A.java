package A;

import java.util.Scanner;

public class CF294_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 5 min
        // implement time 4 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int lines[] = new int[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int line = scanner.nextInt() - 1;
            int num = scanner.nextInt();
            if (line > 0) {
                lines[line - 1] += num - 1;
            }
            if (line < n-1) {
                lines[line + 1] += lines[line] - num;
            }
            lines[line] = 0;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(lines[i]);
        }
    }
}
