package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF231_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        Arrays.sort(arr);
        int max = -1;
        int maxNum = -1;
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            arr[i] += Math.abs(min);
        }
        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {

            int ans = lessSearch(sum, arr[i], k, i + 1);
            if (ans > max || (ans == max && maxNum > arr[i])) {
                max = ans;
                maxNum = arr[i];
            }
        }
        maxNum = maxNum- Math.abs(min);
        System.out.println(max + " " + maxNum);


    }

    static int lessSearch(long[] arr, int x, int k, int i) {
        int start = 0, end = i;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long req = (i * 1L - mid) * x;

            if (arr[i] - arr[mid] + k >= req) {
                end = mid - 1;
                ans = i - mid;
            } else {
                start = mid + 1;
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