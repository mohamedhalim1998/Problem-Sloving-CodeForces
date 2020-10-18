package C;

import java.util.Scanner;

public class CF545_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree[] trees = new Tree[n];
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new Tree(scanner.nextInt(), scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        System.out.println(countCuts(trees, res, n, 0));


    }

    static int countCuts(Tree[] trees, int[] res, int n, int i) {
        if (i == n - 1) {
            return 1;
        }
        int m = res[i];
        if (m != -1) {
            return m;
        }
        if (i == 0) {
            m = 1 + countCuts(trees, res, n, i + 1);
        } else {
            Tree prev = trees[i - 1];
            Tree cur = trees[i];
            Tree next = trees[i + 1];
            if (cur.x - cur.h > prev.x) {
                m = 1 + countCuts(trees, res, n, i + 1);
            }
            if (cur.x + cur.h < next.x) {
                cur.x = cur.x + cur.h;
                m = Math.max(m, 1 + countCuts(trees, res, n, i + 1));
            }
            m = Math.max(m, countCuts(trees, res, n, i + 1));
        }
        res[i] = m;
        return m;
    }


    static class Tree {
        int x;
        int h;

        public Tree(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }
}
