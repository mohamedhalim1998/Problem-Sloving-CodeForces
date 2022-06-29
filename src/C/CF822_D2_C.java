package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF822_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long n = scanner.nextInt();
        long x = scanner.nextInt();
        Trip[] node = new Trip[(int) (2 * n)];
        int index = 0;
        long[] l = new long[(int) n], r = new long[(int) n], cost = new long[(int) n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
            cost[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            node[index++] = new Trip(l[i], r[i], cost[i], 1);
        }
        for (int i = 0; i < n; i++) {
            node[index++] = new Trip(r[i], l[i], cost[i], -1);
        }
        Arrays.sort(node);
        long ans = Integer.MAX_VALUE;
        long[] bestCost = new long[2000000];
        Arrays.fill(bestCost, Integer.MAX_VALUE);
        for (int i = 0; i < index; i++) {
            if (node[i].t == 1) {
                long curLen = node[i].r - node[i].l + 1;
                if (curLen > x) {
                    continue;
                }
                long reqLen = x - curLen;

                ans = Math.min(ans, node[i].c + bestCost[(int) reqLen]);
            } else {
                long curLen = node[i].l - node[i].r + 1;
                bestCost[(int) curLen] = Math.min(node[i].c, bestCost[(int) curLen]);
            }
        }
        System.out.println((ans >= Integer.MAX_VALUE) ? -1 : ans);
    }


    static class Trip implements Comparable<Trip> {
        long l, r, c;

        int t;

        public Trip(long l, long r, long c, int t) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.t = t;
        }

        @Override
        public int compareTo(Trip o) {
            return Long.compare(l, o.l);
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
