package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CF1179_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
//        Arrays.sort(arr);
        ArrayList<Pair> first = new ArrayList<>();
        int min = 0;
        int max = 0;
        int x = list.remove();
        int y = list.remove();
        min = Math.min(x, y);
        max = Math.max(x, y);
        list.add(min);
        first.add(new Pair(x, y));
        for (int i = 2; i < n; i++) {
            int a = list.remove();
            first.add(new Pair(max, a));
            min = Math.min(max, a);
            max = Math.max(max, a);
            list.add(min);
        }
        ArrayList<Pair> repeat = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int a = list.remove();
            repeat.add(new Pair(max, a));
            min = Math.min(max, a);
            max = Math.max(max, a);
            list.add(min);
        }
//        System.out.println(Arrays.toString(first.toArray()));
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long a = scanner.nextLong();
            if (a < n) {
                out.append(first.get((int) a - 1));
            } else {
                long mod = (a - 1) % repeat.size();
                out.append(repeat.get((int) mod));
            }
        }
        System.out.print(out);

    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b + "\n";
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