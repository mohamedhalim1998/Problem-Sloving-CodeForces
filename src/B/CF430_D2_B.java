package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF430_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == x && arr[i + 1] == x) {
                count = Math.max(count, check(arr, i));
            }
        }
        System.out.println(Math.max(count - 1, 0));


    }

    private static int check(int[] arr, int s) {
        int count = 1;
        int curr = arr[s];
        int sum = 0;
        int l = s;
        int r = s + 1;
        while (true) {
            while (r < arr.length && arr[r] == curr) {
                r++;
                count++;
            }
            while (l >= 0 && arr[l] == curr) {
                l--;
                count++;
            }
            if (count >= 3) {
                sum += count;
                count = 0;
            } else {
                break;
            }
            if (l >= 0) {
                curr = arr[l];
            } else {
                break;
            }
        }
//        if (s + 1 < arr.length && arr[s + 1] == arr[s]) {
//            int l = s - 1;
//            int r = s + 2;
//            count = 2;
//            boolean found = true
//            while (found) {
//                found = false;
//                while (arr[l] == arr[])
//            }
//        }
        return sum;
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
