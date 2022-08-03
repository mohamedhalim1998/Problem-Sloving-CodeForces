package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF124_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int[] values = new int[s.length() + 1];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int curr = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (isPrime(i)) {
                boolean change = false;
                for (int j = i; j <= s.length(); j += i) {
                    if (values[j] != 0) {
                        curr = values[j];
                        change = true;
                        break;
                    } else {
                        values[j] = curr;
                    }
                }
                if (change) {
                    for (int j = i; j <= s.length(); j += i) {
                        values[j] = curr;
                    }
                }
                curr++;
            }
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i <= s.length(); i++) {
            if (values[i] != 0)
                freq.put(values[i], freq.getOrDefault(values[i], 0) + 1);
        }
        ArrayList<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pairs.add(new Pair(e.getKey(), e.getValue()));
        }
        Collections.sort(pairs);
        for (Pair p : pairs) {
            HashMap<Character, Integer> temp = new HashMap<>();
            boolean found = false;
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                if (e.getValue() >= p.freq && !found) {
                    p.c = e.getKey();
                    temp.put(e.getKey(), e.getValue() - p.freq);
                    found = true;
                } else {
                    temp.put(e.getKey(), e.getValue());
                }
            }
            map = temp;
        }
        char[] arr = new char[s.length()];
        Arrays.fill(arr, '?');
        for (Pair p : pairs) {
            if (p.c == '?') {
                System.out.println("NO");
                return;
            }
            for (int i = 2; i <= s.length(); i++) {
                if (values[i] == p.val) {
                    arr[i - 1] = p.c;
                }
            }
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int val = e.getValue();
            if (val > 0) {
                for (int i = 0; i < s.length() && val > 0; i++) {
                    if (arr[i] == '?') {
                        arr[i] = e.getKey();
                        val--;
                    }
                }
            }
        }
        System.out.println("YES");
        System.out.println(String.valueOf(arr));
//        System.out.println(pairs);


    }

    static class Pair implements Comparable<Pair> {
        int val;
        int freq;
        char c = '?';

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.freq, freq);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", freq=" + freq +
                    ", c=" + c +
                    '}';
        }
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
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
