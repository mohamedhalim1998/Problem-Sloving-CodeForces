package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1552_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i, scanner.nextArray(5));
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int win = 0;
        for (int i = 1; i < n; i++) {
            Player p1 = players[win];
            Player p2 = players[i];
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (p1.rank[j] < p2.rank[j]) {
                    count++;
                }
            }
            if (count < 3) {
                win = i;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == win)
                continue;
            Player p1 = players[win];
            Player p2 = players[i];
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (p1.rank[j] < p2.rank[j]) {
                    count++;
                }
            }
            if (count >= 3) {
                res++;
            }
        }


        if (res == n - 1) {
            System.out.println(win + 1);
            return;
        }

        System.out.println(-1);

    }


    static class Player {
        int index;
        int[] rank;

        public Player(int index, int[] rank) {
            this.index = index;
            this.rank = rank;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return index == player.index;

        }

        @Override
        public int hashCode() {
            int result = Objects.hash(index);
            result = 31 * result + Arrays.hashCode(rank);
            return result;
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