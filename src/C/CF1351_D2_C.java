package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1351_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        String s = scanner.next();
        HashSet<Path> set = new HashSet<>();
        Pair curr = new Pair(0, 0);
        long time = 0;
        Path p;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'N':
                    p = new Path(curr, new Pair(curr.x, curr.y - 1));
                    curr = new Pair(curr.x, curr.y - 1);
                    if (set.contains(p)) {
                        time += 1;
                    } else {
                        time += 5;
                        set.add(p);
                    }
                    break;
                case 'S':
                    p = new Path(curr, new Pair(curr.x, curr.y + 1));
                    curr = new Pair(curr.x, curr.y + 1);
                    if (set.contains(p)) {
                        time += 1;
                    } else {
                        time += 5;
                        set.add(p);
                    }
                    break;
                case 'E':
                    p = new Path(curr, new Pair(curr.x + 1, curr.y));
                    curr = new Pair(curr.x + 1, curr.y);
                    if (set.contains(p)) {
                        time += 1;
                    } else {
                        time += 5;
                        set.add(p);
                    }
                    break;
                case 'W':
                    p = new Path(curr, new Pair(curr.x - 1, curr.y));
                    curr = new Pair(curr.x - 1, curr.y);
                    if (set.contains(p)) {
                        time += 1;
                    } else {
                        time += 5;
                        set.add(p);
                    }
                    break;
            }
        }
        System.out.println(time);

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
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Path {
        Pair from, to;

        public Path(Pair from, Pair to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return (path.from.equals(from) && path.to.equals(to)) || (path.from.equals(to) && path.to.equals(from));
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to) + Objects.hash(to, from);
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
    }
}