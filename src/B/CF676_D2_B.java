package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF676_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        ArrayList<ArrayList<Glass>> glasses = new ArrayList<>();
        int fill = 1024;
        for (int i = 0; i < n; i++) {
            ArrayList<Glass> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(new Glass(j, fill));
            }
            glasses.add(list);
        }
        if (t == 0) {
            System.out.println(0);
            return;
        }
        glasses.get(0).get(0).level += fill;
        for (int i = 1; i < t; i++) {
            fill = 1024;
            glasses.get(0).get(0).level += fill;
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k <= j; k++) {
                    if (glasses.get(j).get(k).isFull()) {
                        fill = glasses.get(j).get(k).level - 1024;
                        fill /= 2;
                        glasses.get(j).get(k).level -= fill * 2;
                        glasses.get(j + 1).get(k).level += fill;
                        glasses.get(j + 1).get(k + 1).level += fill;
                    }
                }
            }
//            for (ArrayList<Glass> list : glasses) {
//                System.out.println(list);
//            }
//            System.out.println();
//            System.out.println();

        }
        int count = 0;
        for (ArrayList<Glass> list : glasses) {
           // System.out.println(list);
            for (Glass g : list) {
                if (g.level >= g.fill) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    static class Glass {
        int index;
        int fill;
        int level;

        public Glass(int index, int fill) {
            this.index = index;
            this.fill = fill;
        }

        public boolean isFull() {
            return level > fill;
        }

        @Override
        public String
        toString() {
            return level + "";
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