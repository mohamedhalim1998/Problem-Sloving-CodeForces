package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF199_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int r1 = scanner.nextInt();
        int R1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int R2 = scanner.nextInt();
        Circle[] arr = new Circle[4];
        arr[0] = new Circle(x1, y1, r1);
        arr[1] = new Circle(x1, y1, R1);
        arr[2] = new Circle(x2, y2, r2);
        arr[3] = new Circle(x2, y2, R2);
        int count = 0;
        if (!arr[0].intersect(arr[2]) && !arr[0].intersect(arr[3]) && !arr[0].between(arr[2], arr[3])) {
            count++;
        }
        if (!arr[1].intersect(arr[2]) && !arr[1].intersect(arr[3]) && !arr[1].between(arr[2], arr[3])) {
            count++;
        }
        if (!arr[2].intersect(arr[0]) && !arr[2].intersect(arr[1]) && !arr[2].between(arr[0], arr[1])) {
            count++;
        }
        if (!arr[3].intersect(arr[0]) && !arr[3].intersect(arr[1]) && !arr[3].between(arr[0], arr[1])) {
            count++;
        }
        System.out.println(count);


    }

    static class Circle {
        int x, y, r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean intersect(Circle c2) {
            double c1c2 = Math.pow(x - c2.x, 2) + Math.pow(y - c2.y, 2);
//            f C1C2 <= R1 – R2: Circle B is inside A.
//                    If C1C2 <= R2 – R1: Circle A is inside B.
//                    If C1C2 < R1 + R2: Circle intersects each other.
//            If C1C2 == R1 + R2: Circle A and B are in touch with each other.
            return Math.pow(r - c2.r, 2) < c1c2 && c1c2< Math.pow(r + c2.r, 2);

        }

        public boolean between(Circle c1, Circle c2) {
            double d = Math.sqrt(Math.pow(c1.x - x, 2) + Math.pow(c1.y - y, 2));
            return (r + d <= c2.r && r + d > c1.r);
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "x=" + x +
                    ", y=" + y +
                    ", r=" + r +
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
