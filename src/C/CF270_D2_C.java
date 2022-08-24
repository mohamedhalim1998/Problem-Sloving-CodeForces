package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF270_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(pairs);
        int size = pairs[0].k + 1;
        long fit = 4;
        for (int i = pairs[0].k, j = 0; i >= 0 && j < n; i--) {
            if(fit >= 1e9){
                System.out.println(size);
                return;
            }
            if (pairs[j].k == i) {
                if (pairs[j].n > fit) {
                    size++;
                    j--;
                    i++;
                }
                j++;
            }
            fit *= 4;
        }
        System.out.println(size);
    }

    static class Pair implements Comparable<Pair> {
        int k;
        int n;

        public Pair(int k, int n) {
            this.k = k;
            this.n = n;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.k, k);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "k=" + k +
                    ", n=" + n +
                    '}';
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
