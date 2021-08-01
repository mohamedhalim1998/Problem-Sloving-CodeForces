package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF699_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            mat[i] = s.toCharArray();
        }
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '*') {
                    list.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (check(list, i, j)) {
                    System.out.println("YES");
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("NO");

    }

    private static boolean check(ArrayList<Pair> list, int x, int y) {
        for(Pair p : list){
            if(p.x != x && p.y != y){
                return false;
            }
        }

        return true;
    }


    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}