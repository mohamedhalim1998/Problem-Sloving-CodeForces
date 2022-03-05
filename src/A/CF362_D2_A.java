package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF362_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }


    }

    private static void solve(FastScanner scanner) {


        char[][] chars = new char[8][8];
        for (int i = 0; i < 8; i++) {
            chars[i] = scanner.next().toCharArray();
        }
        Pair k1 = null;
        Pair k2 = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chars[i][j] == 'K') {
                    if (k1 == null) {
                        k1 = new Pair(i, j);
                    } else {
                        k2 = new Pair(i, j);
                    }
                }
            }
        }


        HashSet<Pair> set1 = new HashSet<>();
        HashSet<Pair> set2 = new HashSet<>();

        addFour(set1, k1);
        addFour(set2, k2);
        for(Pair p : set1){
            if(set2.contains(p) && !p.equals(k1) && !p.equals(k2)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }

    private static void addFour(HashSet<Pair> set, Pair k1) {
        set.add(k1);
        Pair p = new Pair(k1.x + 2, k1.y + 2);
        if (k1.x + 2 < 8 && k1.y + 2 < 8) {
            set.add(p);
//            addFour(set, p);
        }
        p = new Pair(k1.x + 2, k1.y - 2);
        if (k1.x + 2 < 8 && k1.y - 2 > 0) {
            set.add(p);
//            addFour(set, p);
        }
        p = new Pair(k1.x - 2, k1.y + 2);
        if (k1.x - 2 > 0 && k1.y + 2 < 8) {
            set.add(p);
//            addFour(set, p);
        }
        p = new Pair(k1.x - 2, k1.y - 2);
        if (k1.x - 2 > 0 && k1.y - 2 > 0) {
            set.add(p);
//            addFour(set, p);
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
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
