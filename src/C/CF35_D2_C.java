package C;

import java.io.*;
import java.util.*;

public class CF35_D2_C {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();


        Pair[] burn = new Pair[k];
        for (int i = 0; i < k; i++) {
            burn[i] = new Pair(scanner.nextInt() - 1, scanner.nextInt() - 1);
        }
        int[] dest = new int[n * m];
        Arrays.fill(dest, Integer.MAX_VALUE);
        for (Pair p : burn) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dest[i * m + j] = Math.min(dest[i * m + j], Math.abs(p.x - i) + Math.abs(p.y - j));
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n * m; i++) {
            if (dest[max] < dest[i]) {
                max = i;
            }
        }
        Pair last = new Pair(max / m, max % m);
        FileWriter writer = new FileWriter("output.txt");
        writer.write((last.x + 1) + " " + (last.y + 1));
        writer.close();

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static int pairToOne(Pair p, int m) {
            return p.y * m + p.x;
        }

        public int toOne(int m) {
            return y * m + x;
        }

        public static Pair toPair(int p, int m) {
            return new Pair(p % m, p / m);
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
            return Objects.hash(x + y);
        }
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() throws FileNotFoundException {
            br = new BufferedReader(new
                    InputStreamReader(new FileInputStream("input.txt")));
//            br = new BufferedReader(new
//                    InputStreamReader(System.in));
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