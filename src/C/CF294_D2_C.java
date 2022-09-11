package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF294_D2_C {
    static long mod = 1000000007;
    static long count = 0;
    static HashMap<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] s = scanner.nextArray(m);
        Arrays.sort(s);
        long[][] nCr = new long[1001][1001];
        long[] pow = new long[1001];
        pow[0]=1;pow[1]=1;

        for (int i = 2; i <= n; i++) pow[i] = (pow[i - 1] * 2) % mod;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) nCr[i][j] = 1;
                else nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % mod;
            }
        }

        int cnt = 0, tmp;
        long ans = 1;
        for (int i = 0; i < m; i++) {
            if (i == 0) tmp = s[i] - 1;
            else {
                tmp = s[i] - s[i - 1] - 1;
                ans = (ans * pow[tmp]) % mod;
            }
            cnt += tmp;
            ans = (ans * nCr[cnt][tmp]) % mod;
        }
        cnt += n - s[m - 1];
        ans = ans * nCr[cnt][n - s[m - 1]] % mod;
        System.out.println(ans);
    }

    public static long nCr(long n, long r) {
        long ans = 1;
        for (int k = 0; k < r; k++) {
            ans = ans * (n - k) / (k + 1);
        }

        return ans;
    }

    private static long solve(boolean[] arr) {
        int hash = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                hash += i;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                if (i > 0 && !arr[i - 1]) {
                    count++;
                }
                if (i < arr.length - 1 && !arr[i + 1]) {
                    count++;
                }
            }
        }
        if (count < 2)
            return 1;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                if (i > 0 && !arr[i - 1]) {
                    boolean[] copy = Arrays.copyOf(arr, arr.length);
                    copy[i - 1] = true;
                    ans = count * solve(copy);
                }
                if (i < arr.length - 1 && !arr[i + 1]) {
                    boolean[] copy = Arrays.copyOf(arr, arr.length);
                    copy[i + 1] = true;
                    ans = count * solve(copy);
                }
            }
        }
        map.put(hash, ans);
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