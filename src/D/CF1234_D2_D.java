package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CF1234_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        char[] arr = scanner.next().toCharArray();
        int q = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            TreeSet<Integer> set = map.getOrDefault(arr[i], new TreeSet<>());
            set.add(i);
            map.put(arr[i], set);
        }

        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int p = scanner.nextInt() - 1;
                char c = scanner.next().charAt(0);
                TreeSet<Integer> set = map.getOrDefault(arr[p], new TreeSet<>());
                set.remove(p);
                set = map.getOrDefault(c, new TreeSet<>());
                set.add(p);
                map.put(c, set);
                arr[p] = c;

            } else {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int counter = 0;
                for (Map.Entry<Character, TreeSet<Integer>> e : map.entrySet()) {
                    Integer f = e.getValue().floor(r - 1);
                    if (f != null && f >= l - 1) {
                        counter++;
                    }
                }
                out.append(counter).append('\n');

//                HashSet<Character> set = new HashSet<>();
//                for (int j = l - 1; j < r; j++) {
//                    set.add(arr[j]);
//                }
//                out.append(set.size()).append('\n');
            }
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