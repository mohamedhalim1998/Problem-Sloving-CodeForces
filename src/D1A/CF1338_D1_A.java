package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1338_D1_A {
    static long[] sums = new long[50];

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        sums[0] = 0;
        sums[1] = 1;
        for (int i = 2; i < sums.length; i++) {
            sums[i] = sums[i - 1] * 2;
        }
        for (int i = 1; i < sums.length; i++) {
            sums[i] += sums[i - 1];
        }
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int max = Integer.MIN_VALUE + 9;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if(arr[index] < arr[i]){
                index = i;
            }
            int diff = arr[index] - arr[i];
            max = Math.max(max, diff);
//            if (diff > 0) {
//                int index = greaterSearch(sums, diff - 1);
//                arr[i] += sums[index];
//                max = Math.max(max, index + 1);
//            }
        }

        System.out.println(greaterSearch(sums ,max - 1));
    }

    static int greaterSearch(long[] arr, int target) {
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
    }
}