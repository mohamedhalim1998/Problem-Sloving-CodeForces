package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1147_D1_A {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = scanner.nextArray(k);
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            TreeSet<Integer> set = map.getOrDefault(arr[i], new TreeSet<>());
            set.add(i);
            map.put(arr[i], set);
        }
        long count = 0;
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                TreeSet<Integer> set = map.get(i);
                int x = set.first();
                if (i > 1) {
                    if (map.containsKey(i - 1) && map.get(i - 1).ceiling(x) == null) {
                        count++;
                    } else if (!map.containsKey(i - 1)) {
                        count++;
                    }
                }
                if (i < n) {
                    if (map.containsKey(i + 1) && map.get(i + 1).ceiling(x) == null) {
                        count++;
                    } else if (!map.containsKey(i + 1)) {
                        count++;
                    }
                }

            } else {
                count++;
                if (i > 1) {
                    count++;
                }
                if (i < n) {
                    count++;
                }
            }

        }
        System.out.println(count);
//        for (int i = 0; i < n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int i = 0; i < k - 1; i++) {
//            graph.get(arr[i] - 1).add(arr[i + 1] - 1);
//        }
//        long count = 0;
//        boolean[] visited = new boolean[n];
//        dfs(0, visited);
//        if (graph.get(0).size() == 0 && arr[k - 1] != 0) {
//            count += 2;
//        } else if (!visited[1]) {
//            count++;
//        }
//        for (int i = 1; i < n - 1; i++) {
//            visited = new boolean[n];
//            if (graph.get(i).size() == 0 && arr[k - 1] != (i + 1)) {
//                count += 3;
//                continue;
//            }
//            dfs(i, visited);
//            if (!visited[i - 1]) {
//                count++;
//            }
//            if (!visited[i + 1]) {
//                count++;
//            }
//        }
//        visited = new boolean[n];
//        dfs(n - 1, visited);
//        if (graph.get(n - 1).size() == 0 && arr[k - 1] != n) {
//            count += 2;
//        } else if (!visited[n - 2]) {
//            count++;
//        }
//        System.out.println(count);

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