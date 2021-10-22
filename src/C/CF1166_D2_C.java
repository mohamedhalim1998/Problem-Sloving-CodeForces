package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1166_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(arr[i]);
        }
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int d = 2 * arr[i];
            int index = lessSearch(arr, d + 1);
            count += index - i;

        }
        System.out.println(count);

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
    }
}