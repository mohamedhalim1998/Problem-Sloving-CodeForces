package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF320_D2_B {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        HashSet<Pair> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (op == 1) {
                Pair pair = new Pair(index++, x, y);
                for (Pair p : set) {
                    if (canMove(p, pair)) {
                        graph.get(p.index).add(pair.index);
                    }
                    if (canMove(pair, p)) {
                        graph.get(pair.index).add(p.index);
                    }
                }
                set.add(pair);
            } else {
                if (dfs(x - 1, y - 1)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    private static boolean dfs(int s, int d) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.add(x);
                }
            }
        }

        return visited[d];

    }

    private static boolean canMove(Pair p1, Pair p2) {
        return (p2.x < p1.x && p1.x < p2.y) || (p2.x < p1.y && p1.y < p2.y);
    }


    static class Pair implements Comparable<Pair> {
        int index;
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(Pair p) {
            this.x = p.x;
            this.y = p.y;
        }

        public Pair(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            if (pair.x != x) {
                return -Integer.compare(pair.x, x);
            } else {
                return -Integer.compare(pair.y, y);
            }
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

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", x=" + x +
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