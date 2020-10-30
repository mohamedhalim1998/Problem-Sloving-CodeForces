package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF479_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i + 1, scanner.nextInt());
        }
        Arrays.sort(towers);
        StringBuilder out = new StringBuilder();
        int count = 0;
        while (k > 0 && !allEqual(towers)) {
            towers[n - 1].l--;
            towers[0].l++;
            out.append(towers[n - 1].i).append(" ").append(towers[0].i).append("\n");
            k--;
            count++;
            Arrays.sort(towers);
        }
        System.out.println((towers[n - 1].l - towers[0].l) + " " + count);
        System.out.println(out);

    }

    private static boolean allEqual(Tower[] towers) {
        int l = towers[0].l;
        for (Tower t : towers) {
            if (t.l != l) {
                return false;
            }
        }
        return true;
    }


    static class Tower implements Comparable<Tower> {
        int i, l;

        public Tower(int i, int l) {
            this.i = i;
            this.l = l;
        }

        @Override
        public int compareTo(Tower tower) {
            return Integer.compare(l, tower.l);
        }
    }


}
