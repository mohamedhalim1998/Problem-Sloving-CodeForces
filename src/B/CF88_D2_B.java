package B;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CF88_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        HashSet<Character> set = new HashSet<>();
        ArrayList<Integer> shifts = new ArrayList<>();
        char[][] keyboard = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int j = 0;
            for (char c : s.toCharArray()) {
                keyboard[i][j] = c;
                if (c == 'S') {
                    shifts.add(i * m + j);
                } else {
                    set.add(c);
                }
                j++;
            }
        }


        for (int s : shifts) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    double x1 = j + .5;
                    double y1 = i + .5;
                    double x2 = s % m + .5;
                    double y2 = s / m + .5;
                    double dis = caluateDistance(x1, y1, x2, y2);
                    if (dis <= x) {
                        if (keyboard[i][j] != 'S') {
                            set.add(Character.toUpperCase(keyboard[i][j]));
                        }
                    }
                }
            }
        }

        int l = scanner.nextInt();
        String s = scanner.next();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!set.contains(Character.toLowerCase(c))) {
                System.out.println("-1");
                return;
            } else if (!Character.isLowerCase(c) && shifts.size() == 0) {
                System.out.println("-1");
                return;
            } else if (!Character.isLowerCase(c)) {
                if (!set.contains(c)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static double caluateDistance(double x1, double y1, double x2, double y2) {
        double dx = (x1 - x2) * (x1 - x2);
        double dy = (y2 - y1) * (y2 - y1);
        return Math.sqrt(dx + dy);
    }
}
