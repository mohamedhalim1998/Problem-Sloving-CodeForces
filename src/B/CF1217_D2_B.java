package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1217_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        Blow[] blows = new Blow[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            blows[i] = new Blow(scanner.nextInt(), scanner.nextInt());
            max = Math.max(max, blows[i].d);
        }
        Arrays.sort(blows);
        int diff = (blows[0].d - blows[0].h);
        if(x <= max){
            System.out.println(1);
            return;
        }
        if (diff < 1) {
            System.out.println(-1);
            return;
        }

        int a = (int) Math.ceil((x - max) * 1.0 / diff);
        System.out.println(a + 1);


    }

    static class Blow implements Comparable<Blow> {
        int d;
        int h;

        public Blow(int d, int h) {
            this.d = d;
            this.h = h;
        }

        @Override
        public int compareTo(Blow blow) {
            return Integer.compare(blow.d - blow.h, d - h);
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