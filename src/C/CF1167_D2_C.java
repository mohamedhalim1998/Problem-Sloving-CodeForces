package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1167_D2_C {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        UF uf = new UF(n);
        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt();
            if (k == 0) continue;
            if (k == 1) {
                int dumb = scanner.nextInt();
                continue;
            }
            int x = scanner.nextInt() - 1;
            int y = -1;

            for (int j = 0; j < k - 1; j++) {
                y = scanner.nextInt() - 1;
                uf.union(x, y);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[uf.find(i)]++;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(res[uf.find(i)]).append(' ');
        }
        System.out.println(out);
    }


    static public class UF {

        private int[] parent;  // parent[i] = parent of i
        private int count;     // number of components
        private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
        public UF(int n) {
            if (n < 0) throw new IllegalArgumentException();
            count = n;
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }


        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            // make root of smaller rank point to root of larger rank
            if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
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
    }
}