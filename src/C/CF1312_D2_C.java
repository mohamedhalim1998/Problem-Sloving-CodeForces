package C;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1312_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = scanner.nextArrayLong(n);
        Arrays.sort(arr);
        ArrayList<Long> pow = new ArrayList<>();
        pow.add(1L);
        for (int i = 1; i < 1000; i++) {
            if (pow.get(i - 1) * k > 0) {
                pow.add(pow.get(i - 1) * k);
            } else {
                break;
            }
        }
        HashSet<Integer> used = new HashSet<>();
        for (long x : arr) {
            long c = x;
            while (c > 0) {
                int index = lessSearch(pow, c + 1);
                if (index != -1) {
                    if (!used.contains(index)) {
                        c -= pow.get(index);
                        used.add(index);
                    } else {
                        System.out.println("NO");
                        return;
                    }

                } else {
                    System.out.println("NO");
                    return;
                }
            }
            if (c != 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static int lessSearch(ArrayList<Long> arr, long x) {
        int start = 0, end = arr.size() - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) >= x) {
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

        public long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}