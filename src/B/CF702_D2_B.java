package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class CF702_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();

        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();

            map.put(x, map.getOrDefault(x, 0L) + 1);
        }
        long count = 0;
        HashSet<Long> powers = new HashSet<>();
        long s = 1;
        while (s > 0) {
            powers.add(s);
            s *= 2;
        }
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            long x = e.getKey();
            for (long y : powers) {
                if (map.containsKey(y - x)) {
                    if (x == y - x) {
                        count += e.getValue() * (e.getValue() - 1);
                    } else {
                        count += map.get(x) * map.get(y - x);
                    }
                }
            }
        }
        System.out.println(count / 2);

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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
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