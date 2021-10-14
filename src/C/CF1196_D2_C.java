package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1196_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        Robot[] robots = new Robot[n];
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[] arr = scanner.nextArray(4);
            robots[i] = new Robot(x, y, arr);
            xs[i] = x;
            ys[i] = y;
        }
        for (int i = 0; i < n; i++) {
            int x1 = xs[i];
            L1:
            for (int j = 0; j < n; j++) {
                int y1 = ys[j];
                boolean found = true;
                for (int k = 0; k < n; k++) {
                    int x2 = robots[k].x;
                    int y2 = robots[k].y;
                    if (x1 > x2 && robots[k].functions[2] == 0) {
                        break L1;
                    }
                    if (x1 < x2 && robots[k].functions[0] == 0) {
                        break L1;
                    }
                    if (y1 > y2 && robots[k].functions[1] == 0) {
                        found = false;
                        break;
                    }
                    if (y1 < y2 && robots[k].functions[3] == 0) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    out.append(1 + " ").append(x1).append(" ").append(y1).append('\n');
                    return;
                }
            }
        }
        out.append(0).append('\n');

    }

    static class Robot {
        int x, y;
        int[] functions;

        public Robot(int x, int y, int[] functions) {
            this.x = x;
            this.y = y;
            this.functions = functions;
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