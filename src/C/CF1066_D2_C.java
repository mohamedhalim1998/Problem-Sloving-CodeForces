package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1066_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int l = 100000;
        int r = 100000;
        HashMap<Integer, Integer> books = new HashMap<>();
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        char q = scanner.next().charAt(0);
        int id = scanner.nextInt();
        books.put(id, l);
        l--;
        r++;
        for (int i = 1; i < n; i++) {
            q = scanner.next().charAt(0);
            id = scanner.nextInt();
            if (q == 'L') {
                books.put(id, l);
                l--;
            } else if (q == 'R') {
                books.put(id, r);
                r++;
            } else {
                int min = Math.min(r - books.get(id), books.get(id) - l) - 1;
                out.append(min).append('\n');
            }
        }
        System.out.print(out);

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