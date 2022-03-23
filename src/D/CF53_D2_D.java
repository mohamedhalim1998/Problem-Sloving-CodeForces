package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF53_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] sorted = scanner.nextArray(n);
        int[] arr = scanner.nextArray(n);
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            ArrayList<Pair> list = new ArrayList<>();
            while (sorted[i] != arr[j]) {
                j++;
                list.add(new Pair(j - 1, j));
            }
            Collections.reverse(list);
            for(Pair p : list) {
                pairs.add(p);
                int temp = arr[p.x];
                arr[p.x] = arr[p.y];
                arr[p.y] = temp;
            }
        }
        System.out.println(pairs.size());
        for(Pair p : pairs){
            System.out.println(p);
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return (x+1) + " " + (y+1);
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
