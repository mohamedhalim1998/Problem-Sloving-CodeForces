package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF378_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.next().toCharArray();
        }
        for (int i = 0; i < n * m; i++) {
            graph.add(new ArrayList<>());
        }
        int free = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '.') {
                    Point p = new Point(j, i);
                    count++;
                    if (free == -1) {
                        free = p.toOne(m);
                    }
                    Point other = p.moveDown();
                    if (other.x >= 0 && other.y >= 0 && other.x < m && other.y < n && mat[other.y][other.x] == '.') {
                        graph.get(p.toOne(m)).add(other.toOne(m));
                    }
                    other = p.moveUp();
                    if (other.x >= 0 && other.y >= 0 && other.x < m && other.y < n && mat[other.y][other.x] == '.') {
                        graph.get(p.toOne(m)).add(other.toOne(m));
                    }
                    other = p.moveLeft();
                    if (other.x >= 0 && other.y >= 0 && other.x < m && other.y < n && mat[other.y][other.x] == '.') {
                        graph.get(p.toOne(m)).add(other.toOne(m));
                    }
                    other = p.moveRight();
                    if (other.x >= 0 && other.y >= 0 && other.x < m && other.y < n && mat[other.y][other.x] == '.') {
                        graph.get(p.toOne(m)).add(other.toOne(m));
                    }
                }
            }
        }

        boolean[] visited = new boolean[graph.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(free);
        while (!stack.isEmpty() && count > k) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                count--;
            }
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.push(x);
                }
            }
        }
        for (int i = 0; i < graph.size(); i++) {
            Point p = Point.toPoint(i, m);
            if (!visited[i] && mat[p.x][p.y] == '.') {
                mat[p.x][p.y] = 'X';
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(String.valueOf(mat[i]));
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

        public int toOne(int m) {
            return y * m + x;

        }

        public static Point toPoint(int p, int m) {
            return new Point(p / m, p % m);
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
