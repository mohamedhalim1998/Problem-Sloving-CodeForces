package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF8_D2_B {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        boolean[][] open = new boolean[200][200];
        for (int i = 0; i < 40000; i++) {
            graph.add(new ArrayList<>());
        }
        Point curr = new Point(100, 100);
        open[curr.x][curr.y] = true;
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case 'U':
                    curr = curr.moveUp();
                    break;
                case 'D':
                    curr = curr.moveDown();
                    break;
                case 'L':
                    curr = curr.moveLeft();
                    break;
                case 'R':
                    curr = curr.moveRight();
                    break;
            }
            open[curr.x][curr.y] = true;
        }
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                if (open[i][j]) {
                    Point c = new Point(i, j);
                    if (open[i + 1][j]) {
                        graph.get(c.toOne()).add(new Point(i + 1, j).toOne());
                    }
                    if (open[i - 1][j]) {
                        graph.get(c.toOne()).add(new Point(i - 1, j).toOne());
                    }
                    if (open[i][j + 1]) {
                        graph.get(c.toOne()).add(new Point(i, j + 1).toOne());
                    }
                    if (open[i][j - 1]) {
                        graph.get(c.toOne()).add(new Point(i, j - 1).toOne());
                    }
                }
            }
        }
        boolean[] visited = new boolean[graph.size()];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Point(100, 100).toOne());
        int[] dist = new int[40000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[new Point(100, 100).toOne()] = 0;
        while (!list.isEmpty()) {
            int c = list.remove();
            visited[c] = true;
            for (int x : graph.get(c)) {
                if (!visited[x]) {
                    list.add(x);
                    dist[x] = Math.min(dist[x], dist[c] + 1);
                }
            }
        }

        if (dist[curr.toOne()] != s.length()) {
            System.out.println("BUG");
        } else {
            System.out.println("OK");
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
            return y * 200 + x;
        }

        public static Point toPoint(int p) {
            return new Point(p % 200, p / 200);
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