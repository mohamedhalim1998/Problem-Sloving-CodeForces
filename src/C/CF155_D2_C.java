package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF155_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int k = scanner.nextInt();
        HashSet<Pair> pairs = new HashSet<>();
        for (int i = 0; i < k; i++) {
            char[] arr = scanner.next().toCharArray();
            pairs.add(new Pair(arr[0], arr[1]));
        }
        int count = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); ) {

            boolean found = false;
            for (Pair p : pairs) {
                int a = 0;
                int b = 0;
                while (i < s.length() && p.contains(arr[i])) {
                    found = true;
                    if (arr[i] == p.a) {
                        a++;
                    } else {
                        b++;
                    }
                    i++;
                }
                count += Math.min(a, b);
            }
            if (!found) {
                i++;
            }

        }
        System.out.println(count);


    }

    static class Pair {
        char a, b;

        public Pair(char a, char b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (a == pair.a && b == pair.b) || (a == pair.b && b == pair.a);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a + b);
        }

        public char other(char c) {
            if (a == c) {
                return b;
            } else {
                return a;
            }
        }

        public boolean contains(char c) {
            return c == a || c == b;
        }


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
