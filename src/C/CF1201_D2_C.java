package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1201_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long k = scanner.nextInt();
        long[] arr = scanner.nextArrayLong(n);
        Arrays.sort(arr);
        int mid = n / 2;
        if (n == 1) {
            System.out.println(arr[0] + k);
            return;
        }

        int i = mid + 1;
        long diff = 1;
        while (i < n && k > 0) {
            if (arr[mid] < arr[i]) {
                long d = arr[i] - arr[mid];
                k -= diff * d;
                arr[mid] = arr[i];
            }
            diff++;
            i++;
        }
        if (k > 0) {
            arr[mid] += k / diff;
            k -= (diff * (k / diff));
        }
        if (k < 0) {
            long div = (Math.abs(k) + diff - 2) / (diff - 1);
            arr[mid] -= div;
        }
        System.out.println(arr[mid]);
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
    }
}