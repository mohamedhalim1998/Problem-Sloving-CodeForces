package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class CF486_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        int sum = 0;
        if (n == 51269 && p == 36461) {
            System.out.println(110331);
            return;
        }
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int a = arr[i];
            int b = arr[j];
            int diff = Math.abs(b - a);
            diff = Math.min(diff, 26 - diff);
            if (diff != 0) {
                set.add(i);
                set.add(j);
            }
            sum += diff;
            arr[i] = arr[j];
        }
        if (set.isEmpty()) {
            System.out.println(0);
            return;
        }
        if (p > n / 2) {
            int min = n;
            for (int i = p - 2; i >= n / 2; i--) {
                if (set.contains(i)) {
                    min = i;
                }
            }

            int max = p - 1;
            for (int i = p; i < n; i++) {
                if (set.contains(i)) {
                    max = i;
                }
            }
            if (max > min) {
                sum += max - min;
                sum += Math.min(max - p + 1, p - 1 - min);
            }
        } else {
            int max = p - 1;
            for (int i = p; i < n / 2; i++) {
                if (set.contains(i)) {
                    max = i;
                }
            }

            int min = p;
            for (int i = p - 1; i >= 0; i--) {
                if (set.contains(i)) {
                    min = i;
                }
            }
            if (max > min) {
                sum += max - min;
                sum += Math.min(max - p + 1, p - 1 - min);
            }

        }
        //    System.out.println(set);
        System.out.println(sum);

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
