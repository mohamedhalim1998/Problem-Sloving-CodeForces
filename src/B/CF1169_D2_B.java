package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1169_D2_B {
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashSet<Pair> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Pair p = new Pair(scanner.nextInt(), scanner.nextInt());
            if (!set.contains(p)) {
                set.add(p);
                map.put(p.x, map.getOrDefault(p.x, 0) + 1);
                map.put(p.y, map.getOrDefault(p.y, 0) + 1);

            }
        }
        HashMap<Integer, ArrayList<Integer>> vals = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ArrayList<Integer> list = vals.getOrDefault(e.getValue(), new ArrayList<>());
            list.add(e.getKey());
            vals.put(e.getValue(), list);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int s = set.size() - e.getValue() + 1;
            if (vals.containsKey(s)) {
//                System.out.println(e.getKey());
                System.out.println("YES");
                return;
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int s = set.size() - e.getValue();
            for (int x : vals.getOrDefault(s, new ArrayList<>())) {
                if (x != e.getKey() && !set.contains(new Pair(x, e.getKey()))) {
//                    System.out.println(e.getKey() + " " + x);
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");


    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            if (x == pair.x) {
                return Integer.compare(y, pair.y);
            } else if (y == pair.y) {
                return Integer.compare(x, pair.x);
            } else if (x == pair.y) {
                return Integer.compare(y, pair.x);
            } else if (y == pair.x) {
                return Integer.compare(x, pair.y);
            }
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (x == pair.x && y == pair.y) ||
                    (x == pair.y && y == pair.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x + y);
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