package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class CF1481_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] init = scanner.nextArray(n);
        int[] fin = scanner.nextArray(n);
        int[] paint = scanner.nextArray(m);
        HashMap<Integer, Integer> initMap = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (init[i] != fin[i]) {
                LinkedList<Integer> list = map.getOrDefault(fin[i], new LinkedList<>());
                list.add(i + 1);
                map.put(fin[i], list);
            }
        }
        for (int i = 0; i < n; i++) {
            if (init[i] == fin[i]) {
                initMap.put(init[i], i + 1);
            }
        }
//        if(map.isEmpty()){
//            System.out.println("YES");
//
//
//        }
        int[] p = new int[m];
        int last = -1;
        for (int i = m - 1; i >= 0; i--) {
            LinkedList<Integer> list = map.getOrDefault(paint[i], new LinkedList<>());
            if (list.isEmpty() && last == -1) {
                if (initMap.containsKey(paint[i])) {
                    p[i] = initMap.get(paint[i]);
                    last = p[i];
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if (list.isEmpty()) {
                p[i] = last;
            } else {
                if (last == -1)
                    last = list.peek();
                p[i] = list.poll();
            }
        }
        for (Map.Entry<Integer, LinkedList<Integer>> e : map.entrySet()) {
            if (!e.getValue().isEmpty()) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        printArrayInLine(p);


    }

    static HashMap<Integer, Integer> arrToMap(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map;
    }

    public static void printArrayInLine(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}