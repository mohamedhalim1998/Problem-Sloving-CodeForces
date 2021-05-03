package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1393_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum2 = 0;
        int sum4 = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            sum2 -= (map.getOrDefault(x, 0) / 2);
            sum4 -= (map.getOrDefault(x, 0) / 4);
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum2 += (map.getOrDefault(x, 0) / 2);
            sum4 += (map.getOrDefault(x, 0) / 4);
        }
        int q = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            char c = scanner.next().charAt(0);
            int x = scanner.nextInt();
            sum2 -= (map.getOrDefault(x, 0) / 2);
            sum4 -= (map.getOrDefault(x, 0) / 4);
            if (c == '+') {
                map.put(x, map.getOrDefault(x, 0) + 1);
            } else {
                map.put(x, map.getOrDefault(x, 0) - 1);
            }
            sum2 += (map.getOrDefault(x, 0) / 2);
            sum4 += (map.getOrDefault(x, 0) / 4);
            if (sum4 >= 1 && sum2 >= 4) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
            //            int s = -1;
//            int r1 = -1;
//            int r2 = -1;
//            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//                if (s == -1 && e.getValue() >= 4) {
//                    s = e.getKey();
//                    map.put(e.getKey(), e.getValue() - 4);
//                }
//                if (r1 == -1 && e.getValue() >= 2) {
//                    r1 = e.getKey();
//                    map.put(e.getKey(), e.getValue() - 2);
//                }
//                if (r2 == -1 && e.getValue() >= 2) {
//                    r2 = e.getKey();
//                    map.put(e.getKey(), e.getValue() - 2);
//                }
//            }
//            if (s != -1 && r1 != -1 && r2 != -1) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//            if (s != -1) {
//                map.put(s, map.get(s) + 4);
//            }
//            if (r1 != -1) {
//                map.put(r1, map.get(r1) + 2);
//            }
//            if (r2 != -1) {
//                map.put(r2, map.get(r2) + 2);
//            }
        }
        System.out.println(out);
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