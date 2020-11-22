package C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class CF1409_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        ArrayList<Integer> list = divisors(y - x);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            int a = list.get(i);
            ArrayList<Integer> ans = new ArrayList<>();
            int r = y;
            int t = 0;
            boolean foundX = false;
            while (r > 0 && t++ < n) {
                if (r == x) {
                    foundX = true;
                }
                ans.add(r);
                r -= a;
            }


            if (ans.size() >= n && foundX) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ans.get(j) + " ");
                }
                System.out.println();
                return;
            }
            if (foundX && t < n) {
                if (min > n - t) {
                    min = n - t;
                    minIndex = i;
                }
            }
        }

        int r = y;
        while (r > 0) {
            System.out.print(r + " ");
            r -= list.get(minIndex);
        }
        r = y + list.get(minIndex);
        for (int i = 0; i < min; i++) {
            System.out.print(r + " ");
            r += list.get(minIndex);
        }
        System.out.println();

    }

    static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        return list;
    }
}
