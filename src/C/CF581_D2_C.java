package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF581_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Item(scanner.nextInt());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].x < 100) {
                int diff = (10 - arr[i].x % 10);
                if (k - diff >= 0) {
                    arr[i].x += diff;
                    k -= diff;

                }
            }
            sum += arr[i].x / 10;
        }


        if (k > 10 && sum < n * 10) {
            System.out.println(Math.min(sum + k / 10, n * 10));
        } else {
            System.out.println(sum);
        }


    }

    static class Item implements Comparable<Item> {
        int x;

        public Item(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Item item) {
            return Integer.compare(item.x % 10, x % 10);
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