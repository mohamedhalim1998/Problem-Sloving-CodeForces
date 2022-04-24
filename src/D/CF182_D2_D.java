package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF182_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        String t = scanner.next();
        HashSet<String> setS = new HashSet<>();
        setS.add(s);

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                boolean divisor = true;
                for (int j = i; j < s.length(); j += i) {
                    for (int k = 0; k < i; k++) {
                        if (s.charAt(k) != s.charAt(k + j)) {
                            divisor = false;
                            break;
                        }
                    }
                    if (!divisor) {
                        break;
                    }
                }
                if (divisor) {
                    setS.add(s.substring(0, i));
                }
            }
        }
        HashSet<String> setT = new HashSet<>();
        setT.add(t);

        for (int i = 1; i <= t.length() / 2; i++) {
            if (t.length() % i == 0) {
                boolean divisor = true;
                for (int j = i; j < t.length(); j += i) {
                    for (int k = 0; k < i; k++) {
                        if (t.charAt(k) != t.charAt(k + j)) {
                            divisor = false;
                            break;
                        }
                    }
                    if (!divisor) {
                        break;
                    }
                }
                if (divisor) {
                    setT.add(t.substring(0, i));
                }
            }
        }
        int count = 0;
        for (String x : setS) {
            if (setT.contains(x)) {
                count++;
            }
        }
        System.out.println(count);


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