package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF400_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = scanner.next().toCharArray();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int c = indexOfCandy(chars[i]);
            int d = indexOfDawrf(chars[i]);

            if (c - d < 0) {
                System.out.println("-1");
                return;
            }
            set.add(c - d);
        }
        System.out.println(set.size());
    }

    private static int indexOfDawrf(char[] line) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 'G') {
                return i;
            }
        }
        return 0;
    }

    private static int indexOfCandy(char[] line) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 'S') {
                return i;
            }
        }
        return 0;
    }
}
