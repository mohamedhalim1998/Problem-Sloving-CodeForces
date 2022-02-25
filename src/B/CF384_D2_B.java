package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF384_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[][] mat = new Integer[n][m];
        Integer[][] sorted = new Integer[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.nextArray(m, true);
            sorted[i] = Arrays.copyOf(mat[i], m);
            if (k == 0) {
                Arrays.sort(sorted[i]);
            } else {
                Arrays.sort(sorted[i], Collections.reverseOrder());
            }
        }
        LinkedHashSet<Pair> pairs = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!mat[j][i].equals(sorted[j][i])) {
                    for (int l = i + 1; l < m; l++) {
                        if (mat[j][l].equals(sorted[j][i])) {
                            if(k == 0) {
                                pairs.add(new Pair(i + 1, l + 1));
                            } else {
                                pairs.add(new Pair(l + 1, i + 1));
                            }
                            if(k == 0) {
                                for (int o = 0; o < n; o++) {
                                    if(mat[o][i] > mat[o][l]) {
                                        int temp = mat[o][i];
                                        mat[o][i] = mat[o][l];
                                        mat[o][l] = temp;
                                    }
                                }
                            } else {
                                for (int o = 0; o < n; o++) {
                                    if(mat[o][i] < mat[o][l]) {
                                        int temp = mat[o][i];
                                        mat[o][i] = mat[o][l];
                                        mat[o][l] = temp;
                                    }

                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(pairs.size());
        for (Pair p : pairs) {
            System.out.println(p);
        }


    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(Pair pair) {
            this.x = pair.x;
            this.y = pair.y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (x == pair.x && y == pair.y)
                    || (x == pair.y && y == pair.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x + y);
        }

        @Override
        public String toString() {
            return x + " " + y;
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