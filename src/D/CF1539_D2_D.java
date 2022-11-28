package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1539_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.nextLong(), scanner.nextLong());
        }
        Arrays.sort(items);
        int i = 0;
        int j = n - 1;
        long count = 0;
        long bought = 0;
        while (i <= j) {
            if (bought >= items[j].b) {
                bought += items[j].a;
                count += items[j].a;
                items[j].a = 0;
                j--;
            } else {
                long min = Math.min(items[j].b - bought, items[i].a);
                items[i].a -= min;
                bought += min;
                count += 2 * min;
                if (items[i].a == 0) {
                    i++;
                }
            }
        }
        System.out.println(count);


    }

    static class Item implements Comparable<Item> {
        long a, b;

        public Item(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Item o) {
            if (o.b != b) {
                return Long.compare(o.b, b);
            } else {
                return Long.compare(a, o.a);
            }
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
