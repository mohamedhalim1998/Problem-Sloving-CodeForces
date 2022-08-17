package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF465_D2_C {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int p = scanner.nextInt() - 1;
        char[] arr = scanner.next().toCharArray();

        arr = next(arr, p, n - 1);
        if (arr != null)
            System.out.println(String.valueOf(arr));
        else
            System.out.println("NO");

    }

    private static boolean check(char[] arr) {
        return countPS(arr, arr.length) == 0;
    }

    static int countPS(char str[], int n) {
        int dp[][] = new int[n][n];
        boolean P[][] = new boolean[n][n];
        for (int i = 0; i < n; i++)
            P[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (str[i] == str[i + 1]) {
                P[i][i + 1] = true;
                dp[i][i + 1] = 1;
            }
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = gap + i;
                if (str[i] == str[j] && P[i + 1][j - 1])
                    P[i][j] = true;
                if (P[i][j] == true)
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
                            + 1 - dp[i + 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
                            - dp[i + 1][j - 1];
            }
        }
        return dp[0][n - 1];
    }

    private static char[] next(char[] arr, int p, int prev) {
//        char[] ans = Arrays.copyOf(arr, arr.length);
        int change = -1;
        for (int i = prev; i >= 0; i--) {
            for (int j = Arrays.binarySearch(alphabet, arr[i]) + 1; j <= p; j++) {
                if (i >= 2 && arr[i - 1] != ('a' + j) && arr[i - 2] != ('a' + j)) {
                    change = i;
                    arr[i] = (char) ('a' + j);
                    break;
                } else if (i == 1 && arr[i - 1] != ('a' + j)) {
                    change = i;

                    arr[i] = (char) ('a' + j);
                    break;
                } else if (i == 0) {
                    change = i;

                    arr[i] = (char) ('a' + j);
                    break;
                }
            }
            if (change != -1) {
                break;
            }
        }
        if (change == -1)
            return null;

        for (int i = change + 1; i < arr.length; i++) {
            for (int j = 0; j <= p; j++) {
                if (i >= 2 && arr[i - 1] != ('a' + j) && arr[i - 2] != ('a' + j)) {
                    arr[i] = (char) ('a' + j);
                    break;
                } else if (i == 1 && arr[i - 1] != ('a' + j)) {
                    arr[i] = (char) ('a' + j);
                    break;
                }
            }

        }
        return arr;
    }


    static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
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