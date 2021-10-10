package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1114_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0L;
        for (int i = n - 1; i >= n - m * k && i >= 0; i--) {
            sum += sorted[i];
            map.put(sorted[i], map.getOrDefault(sorted[i], 0) + 1);
        }
        ArrayList<Integer> split = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (x < m &&
                    map.containsKey(arr[i]) &&
                    map.getOrDefault(arr[i], 0) > 0) {
                x++;
                map.put(arr[i], map.get(arr[i]) - 1);
            }
            if (x == m) {
                x = 0;
                split.add(i + 1);
            }
        }

        StringBuilder out = new StringBuilder();
        out.append(sum).append('\n');
        for (int i = 0; i < k - 1; i++) {
            out.append(split.get(i)).append(' ');
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