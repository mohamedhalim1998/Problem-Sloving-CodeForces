package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF6_D2_B {
    public static void main(String[] args) {
        // time reading 2 min
        // think 2 min
        // implement time 5 min
        // debug 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char color = scanner.next().charAt(0);
        char[][] office = new char[n][m];
        for (int i = 0; i < n; i++) {
            office[i] = scanner.next().toCharArray();
        }
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == color) {
                    p.add(i);
                    p.add(j);
                }
            }
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < p.size(); i += 2) {
            int x = p.get(i);
            int y = p.get(i + 1);
            if (x - 1 >= 0 && office[x - 1][y] != color && office[x - 1][y] != '.') {
                set.add(office[x - 1][y]);
            }
            if (x + 1 < n && office[x + 1][y] != color && office[x + 1][y] != '.') {
                set.add(office[x + 1][y]);
            }
            if (y - 1 >= 0 && office[x][y - 1] != color && office[x][y - 1] != '.') {
                set.add(office[x][y - 1]);
            }
            if (y + 1 < m && office[x][y + 1] != color && office[x][y + 1] != '.') {
                set.add(office[x][y + 1]);
            }

        }
        System.out.println(set.size());

    }
}
