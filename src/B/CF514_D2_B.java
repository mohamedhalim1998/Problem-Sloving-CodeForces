package B;

import javax.swing.text.MutableAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CF514_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        ArrayList<Pair> alive = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            alive.add(new Pair(x2, y2));
        }
        ArrayList<Pair> killed = new ArrayList<>();
        killed.add(alive.get(0));
        alive.remove(0);
        int count = 1;
        while (!alive.isEmpty()) {
            Pair p = alive.remove(0);
            boolean akilled = false;
            for (Pair k : killed) {
                if ((k.y - y0) * (p.x - x0) == (p.y - y0) * (k.x - x0)) {
                    akilled = true;
                }
            }
            if (!akilled) {
                count++;
                killed.add(p);
            }
        }
        System.out.println(count);
        // System.out.println(set.size());
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
