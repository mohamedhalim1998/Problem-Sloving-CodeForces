package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1487_D2_D {
    static ArrayList<Item> list = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        int n = (int) 1e9;
        for (long a = 1; a <= 45000; a+=2) {
            long b = a * a - 1;
            if (b > 0 && b % 2 == 0 && b / 2 <= n) {
                b = b / 2;
                long c = a * a - b;
                if (c > 0 && c <= n) {
                    list.add(new Item(a, b, c));
                  //  System.out.println(a + " " + b + " " + c);
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.print(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int count = 0;

        for (Item item : list) {
            if (item.a <= n && item.b <= n && item.c <= n) {
                count++;
            }
            if(item.b > n){
                break;
            }
        }
        out.append(count).append('\n');
    }

    static class Item {
        long a, b, c;


        public Item(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return a == item.a &&
                    b == item.b &&
                    c == item.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
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