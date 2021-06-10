package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1263_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
            list.add(x);
        }
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : list) {
            if (map.get(x) > 1) {
                count++;
                boolean found = false;
                for (int i = x % 10, j = 1; i < 9; i++, j++) {
                    if (!map.containsKey(x + j)) {
                        map.put(x, map.get(x) - 1);
                        map.put(x + j, 1);
                        res.add(x + j);
                        found = true;
                        break;
                    }
                }
                if (!found)
                    for (int i = 1, j = 1; i <= x % 10; i++, j++) {
                        if (!map.containsKey(x - j)) {
                            map.put(x, map.get(x) - 1);
                            map.put(x - j, 1);
                            res.add(x - j);
                            break;
                        }
                    }
//                if (!found)
//                    for (int i = x % 100, j = 10; i < 9; i++, j += 10) {
//                        if (!map.containsKey(x + j)) {
//                            map.put(x, map.get(x) - 1);
//                            map.put(x + j, 1);
//                            res.add(x + j);
//                            break;
//                        }
//                    }
            } else {
                res.add(x);
            }
        }
        System.out.println(count);
        for (int e : res) {
            System.out.printf("%04d\n", e);
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