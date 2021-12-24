package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF709_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        if (n == 1) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long sum = 0;
        int index = lessSearch(arr, s + 1);
        int count = 0;
        if (index > -1) {
            int last = s;
            for (int i = index + 1; i < n - 1; i++) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }
            for (int i = index; i >= 0 && count < n - 1; i--) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }

            min = Math.min(min, sum);
        }
        if (index > -1) {
            sum = 0;
            count = 0;
            int last = s;
            for (int i = index; i >= 0 && count < n - 1; i--) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }
            for (int i = index + 1; i < n && count < n - 1; i++) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }
            min = Math.min(min, sum);
        }
        index = greaterSearch(arr, s - 1);
        if (index > -1) {
            int last = s;
            sum = 0;
            count = 0;
            for (int i = index; i < n && count < n - 1; i++) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }
            for (int i = index - 1; i >= 0 && count < n - 1; i--) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }
            min = Math.min(min, sum);
        }
        if (index > -1) {
            int last = s;
            sum = 0;
            count = 0;
            for (int i = index - 1; i > 0; i--) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }
            for (int i = index; i < n && count < n - 1; i++) {
                count++;
                sum += Math.abs(last - arr[i]);
                last = arr[i];
            }

            min = Math.min(min, sum);
        }
        System.out.println(min);

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


    static int lessSearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
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