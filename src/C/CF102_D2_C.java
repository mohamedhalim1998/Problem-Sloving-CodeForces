package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF102_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int k = scanner.nextInt();
        Item[] items = new Item[26];
        for (int i = 0; i < 26; i++) {
            items[i] = new Item((char) ('a' + i));
        }
        for (char c : s.toCharArray()) {
            items[c - 'a'].count++;
        }
        Arrays.sort(items);
        int index = 0;
        while (index < 26 && k >= items[index].count) {
            k -= items[index].count;
            items[index].count = 0;
            index++;
        }
        HashSet<Character> toRemove = new HashSet<>();
        int count = 0;
        for (Item item : items) {
            if (item.count == 0) {
                toRemove.add(item.c);
            } else {
                count++;
            }

        }
        StringBuilder out = new StringBuilder();
        out.append(count).append("\n");

        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(s.charAt(i))) {
                out.append(s.charAt(i));
            }
        }
        System.out.println(out);
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), );
//        }


    }

    static class Item implements Comparable<Item> {
        char c;
        int count;

        public Item(char c) {
            this.c = c;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(count, o.count);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "c=" + c +
                    ", count=" + count +
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
