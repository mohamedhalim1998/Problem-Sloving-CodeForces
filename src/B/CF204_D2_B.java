package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF204_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Card[] cards = new Card[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int f = scanner.nextInt();
            int b = scanner.nextInt();
            cards[i] = new Card(f, b);
            set.add(f);
            set.add(b);
        }
        HashMap<Integer, Integer> front = new HashMap<>();
        HashMap<Integer, Integer> back = new HashMap<>();

        for (Card c : cards) {
            front.put(c.f, front.getOrDefault(c.f, 0) + 1);
            if (c.f != c.b) {
                back.put(c.b, back.getOrDefault(c.b, 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : set) {
            int f = front.getOrDefault(x, 0);
            int b = back.getOrDefault(x, 0);
            if (f + b >= (n + 1) / 2) {
                min = Math.min(Math.max(0, (n + 1) / 2 - f), min);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);


    }

    static class Card {
        int f, b;

        public Card(int f, int b) {
            this.f = f;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "f=" + f +
                    ", b=" + b +
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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}