package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CF1551_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.next());

        }
        int max = 0;
        for (int i = 0; i < 5; i++) {
            final int key = i;
            Arrays.sort(items, Comparator.comparingInt(item -> item.arr[key]));
            int a = 0;
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                sum += items[j].arr[i];
                if (sum <= 0) {
                    break;
                }
                a++;
            }
            max = Math.max(a, max);
        }
        System.out.println(max);



    }

    static class Item {
        String word;
        int[] arr = new int[5];

        public Item(String word) {
            this.word = word;
            for (int i = 0; i < word.length(); i++) {
                arr[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 5; i++) {
                arr[i] = arr[i] - (word.length() - arr[i]);
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
    }
}