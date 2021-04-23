package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1285C_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long n = scanner.nextLong();
        ArrayList<Pair> list = divisors(n);
        Collections.sort(list);
        Pair res = new Pair(1, n);
        for (Pair p : list) {
            if(lcm(p.x, p.y) == n){
                res = p;
                break;
            }
        }
        System.out.println(res.x + " " + res.y);
    }

    static class Pair implements Comparable<Pair> {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            return Long.compare(Math.max(x, y), Math.max(pair.x, pair.y));
        }
    }

    static ArrayList<Pair> divisors(long n) {
        ArrayList<Pair> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i != i) {
                    list.add(new Pair(i, n / i));
                }
            }
        }
        return list;
    }
    static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
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