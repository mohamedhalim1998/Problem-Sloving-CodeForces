package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1075_D2_C {
//    static int[] freq = new int[1000000009];

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] hor = scanner.nextArray(n);
        Block[] ver = new Block[m];
        for (int i = 0; i < m; i++) {
            ver[i] = new Block(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        if (n == 0) {
            int count = 0;
            for (Block block : ver) {
                if (block.x1 == 1 && block.x2 == 1000000000) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        }
        Arrays.sort(hor);
        Arrays.sort(ver);
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int v = 0, h = n - 1; h >= 0; ) {
            if (v < m) {
                if (ver[v].x1 != 1) {
                    v++;
                    continue;
                }
                if (ver[v].x2 >= hor[h]) {
                    v++;
                    count++;
                    continue;
                }
            }
            min = Math.min(min, count + h);
            h--;
        }
//        int count = 0;
//        int v = 0;
//        for (int i = ver[0].x2; i > hor[n - 1]; i--) {
//            if (v < m) {
//                if (ver[v].x1 != 1) {
//                    v++;
//                    continue;
//                }
//                if (i == ver[v].x2) {
//                    v++;
//                    count++;
//                }
//            }
//        }
//        for (int i = hor[n - 1], h = n - 1; i >= hor[0] && h >= 0; i--) {
//            if (v < m) {
//                if (ver[v].x1 != 1) {
//                    v++;
//                    continue;
//                }
//                if (i == ver[v].x2) {
//                    v++;
//                    count++;
//                }
//            }
//            if (i == hor[h]) {
//                min = Math.min(min, count + h);
//                h--;
//            }

//        }
//        int count = 0;

//        for (int i = 0; i < m; i++) {
//            if (ver[i].x1 == 1) {
//                freq[ver[i].x2]++;
//            }
//        }
//        for (int i = freq.length - 2; i >= 0; i--) {
//            freq[i] += freq[i + 1];
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            min = Math.min(min, freq[hor[i]] + i);
//        }
        int full = 0;
        for (Block block : ver) {
            if (block.x1 == 1 && block.x2 == 1000000000) {
                full++;
            }
        }

        System.out.println(Math.min(min, n + full));


    }


    static class Block implements Comparable<Block> {
        int x1, x2;
        int y;

        public Block(int x1, int x2, int y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        @Override
        public int compareTo(Block block) {
            return Integer.compare(block.x2, x2);
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