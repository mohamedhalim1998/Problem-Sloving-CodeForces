package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF792_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();

        long sum = 0;
        if (s.length() == 1) {
            sum = Long.parseLong(s);
        }
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        if (sum % 3 == 0) {
            System.out.println(s);
            return;
        } else {
            int mod = (int) (sum % 3);
            String res = removeNum(s, mod);
            String min = null;
            if (res != null)
                min = res;
            if (mod == 2) {
                res = removeNum(s, 1);
                res = removeNum(res, 1);
            } else {
                res = removeNum(s, 2);
                res = removeNum(res, 2);
            }
            if (res != null) {
                min = min != null && min.length() > res.length() ? min : res;
            }
            if(min != null){
                System.out.println(min);
                return;
            }

        }
        if (s.contains("0")) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }


    }

    public static String removeNum(String s, int num) {
        if (s == null) {
            return null;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) % 3 == num) {
                index = i;
            }
        }
        if (index != -1) {
            String val = s.substring(0, index) + s.substring(index + 1);
            if (index == 0) {
                index++;
                while (index < s.length() && s.charAt(index) == '0') {
                    index++;
                }
                val = index < s.length() ? s.substring(index) : "";
            }
            if (val.length() == 0)
                return null;
            return val;
        }
        return null;
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