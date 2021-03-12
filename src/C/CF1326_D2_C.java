package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1326_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i = 0, j = n; i < k; i++, j--) {
            set.add(j);
            sum += j;
        }
        long count = 1;
        int len = 0;
        int i = 0;
        while (!set.contains(arr[i])) {
            i++;
        }
        for (i = i + 1; i < n; i++) {
            if (!set.contains(arr[i])) {
                len++;
            } else {
                count *= len + 1;
                count = count % 998244353;
                len = 0;
            }
        }
        System.out.println(sum + " " + count);
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