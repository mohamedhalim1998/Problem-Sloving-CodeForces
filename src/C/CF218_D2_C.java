package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF218_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < 1000 * 1000; i++) {
            graph.add(new ArrayList<>());
        }
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            points.add(new Point(x, y));
        }
        for (Point a : points) {
            for (Point b : points) {
                if (!a.equals(b)) {
                    if (a.x == b.x || a.y == b.y) {
                        graph.get(a.toOne()).add(b.toOne());
                    }
                }
            }
        }

        boolean[] visited = new boolean[graph.size()];
        int count = 0;
        for (Point p : points) {
            if (!visited[p.toOne()]) {
                dfs(p.toOne(), visited);
                count++;
            }
        }
        System.out.println(count - 1);
    }

    private static void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (int x : graph.get(i)) {
            if (!visited[x]) {
                dfs(x, visited);
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point moveLeft() {
            return new Point(x - 1, y);
        }

        public Point moveRight() {
            return new Point(x + 1, y);
        }

        public Point moveUp() {
            return new Point(x, y - 1);
        }

        public Point moveDown() {
            return new Point(x, y + 1);
        }

        public int toOne() {
            return y * 1000 + x;
        }

        public static Point toPoint(int p) {
            return new Point(p % 1000, p / 1000);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
