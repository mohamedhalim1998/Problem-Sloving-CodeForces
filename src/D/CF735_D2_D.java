package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF735_D2_D {
    static boolean[] prime = new boolean[(int) 2e5];

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
//        int max = (int) 2e5;
//        Arrays.fill(prime, true);
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 2; i < max; i++) {
//            if (prime[i]) {
//                list.add(i);
//                for (int j = i + i; j < max; j += i) {
//                    prime[j] = false;
//                }
//            }
//        }
//        int n = scanner.nextInt();
//        int count = 0;
//        while (n >= 2) {
//            int index = lessSearch(list, n + 1);
//            n -= list.get(index);
//            count++;
//        }
//
//        System.out.println(count);
        int n = scanner.nextInt();

        if (isPrime(n)) {
            System.out.println(1);
        } else {
            if (isPrime(n - 2) || n % 2 == 0)
                System.out.println(2);
            else
                System.out.println(3);
        }


    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int lessSearch(ArrayList<Integer> arr, int x) {
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