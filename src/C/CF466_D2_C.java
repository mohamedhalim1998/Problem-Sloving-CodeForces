package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF466_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }
        long a = sum / 3;
        sum = 0;
        int[] count = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            count[i] = count[i + 1];
            sum += arr[i];
            if (sum == a) {
                count[i]++;
            }
        }
        long ans = 0;
        sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum += arr[i];
            if (sum == a) {
                ans += count[i + 2];
            }
        }
        System.out.println(ans);
    }

    static int greaterSearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
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