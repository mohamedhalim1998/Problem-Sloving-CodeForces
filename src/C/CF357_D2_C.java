package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CF357_D2_C {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] knights = new int[n + 9];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i + 1);
        }
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int w = scanner.nextInt();
            ArrayList<Integer> toRemove = new ArrayList<>();
            for (int x : treeSet.subSet(l, true, r, true)) {
                toRemove.add(x);
                knights[x] = w;
            }
            for (int j : toRemove) {
                treeSet.remove(j);
            }
            treeSet.add(w);
            knights[w] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            System.out.print(knights[i] + " ");
        }
        System.out.println();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
