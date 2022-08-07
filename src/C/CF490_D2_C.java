package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF490_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        HashSet<Integer> l = new HashSet<>();
        int rem = Character.getNumericValue(s.charAt(0)) % a;
        if (rem == 0) {
            l.add(0);
        }
        for (int i = 1; i < s.length() - 1; i++) {
            rem = (rem * 10 + Character.getNumericValue(s.charAt(i))) % a;
            if (rem == 0) {
                l.add(i);
            }
        }
        HashSet<Integer> r = new HashSet<>();
        rem = Character.getNumericValue(s.charAt(s.length() - 1)) % b;
        if (rem == 0) {
            r.add(s.length() - 1);
        }
        int p = 10;
        p = p % b;
        for (int i = s.length() - 2; i > 0; i--) {
            rem = (rem + Character.getNumericValue(s.charAt(i)) * p) % b;
            if (rem == 0) {
                r.add(i);
            }
            p *= 10;
            p = p % b;
        }
        for (int x : l) {
            if (r.contains(x + 1) && s.charAt(x + 1) != '0') {
                System.out.println("YES");
                System.out.println(s.substring(0 , x + 1));
                System.out.println(s.substring(x + 1));
                return;
            }
        }
        System.out.println("NO");

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
