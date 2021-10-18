package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1269_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = scanner.nextArrayLong(n);
        long[] b = scanner.nextArrayLong(n);
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add((((b[0] - a[i]) % m) + m) % m);
        }

        HashMap<Long, Long> mapb = arrToMap(b, n);
        HashMap<Long, Long> mapa = arrToMap(a, n);
        for (long i : set) {
            boolean found = true;
            for (Map.Entry<Long, Long> e : mapa.entrySet()) {
                long x = e.getKey();
                x += i;
                if (x >= m) {
                    x %= m;
                }
                if (!mapb.getOrDefault(x, 0L).equals(e.getValue())) {
                    found = false;
                    break;
                }
            }
            if (found) {
                System.out.println(i);
                return;
            }
        }
    }

    static HashMap<Long, Long> arrToMap(long[] arr, int n) {
        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }
        return map;
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

        public long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }

}