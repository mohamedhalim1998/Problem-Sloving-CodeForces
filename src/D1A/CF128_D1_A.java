package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF128_D1_A {

    static int[][] mat = new int[8][8];
    static boolean win = false;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        for (int i = 0; i < 8; i++) {
            String line = scanner.next();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'S') {
                    mat[7 - i][j] = 1;
                }
            }
        }
        solveOne(new Status(0, 0, 0));
        if (!win) {
            System.out.println("LOSE");
        } else {
            System.out.println("WIN");
        }

    }

    private static void solveOne(Status status) {
        ArrayList<Status> list = new ArrayList<>();
        if(status.c == 7){
            win = true;
            return;
        }
        list.add(new Status(status.x, status.y, status.c + 1));
        if (status.x < 7) {
            list.add(new Status(status.x + 1, status.y, status.c + 1));
        }
        if (status.y < 7) {
            list.add(new Status(status.x, status.y + 1, status.c + 1));
        }
        if (status.x > 0)
            list.add(new Status(status.x - 1, status.y, status.c + 1));
        if (status.y > 0)
            list.add(new Status(status.x, status.y - 1, status.c + 1));
        if (status.x < 7 && status.y < 7)
            list.add(new Status(status.x + 1, status.y + 1, status.c + 1));
        if (status.x > 0 && status.y > 0)
            list.add(new Status(status.x - 1, status.y - 1, status.c + 1));
        if (status.x > 0 && status.y < 7)
            list.add(new Status(status.x - 1, status.y + 1, status.c + 1));
        if (status.x < 7 && status.y > 0)
            list.add(new Status(status.x + 1, status.y - 1, status.c + 1));
        if (status.x == 7 && status.y == 7) {
            win = true;
            return;
        } else {
            solveList(list);
        }
    }

    private static void solveList(ArrayList<Status> list) {
        for (Status s : list) {
            int x = s.x;
            int y = s.y;
            int c = s.c;
            if (x + c < 8 && mat[x + c][y] != 1 && mat[x + c - 1][y] != 1) {
                //    s.c++;
                solveOne(s);
            }
        }
    }

    static class Status {
        int x, y, c;

        public Status(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
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
