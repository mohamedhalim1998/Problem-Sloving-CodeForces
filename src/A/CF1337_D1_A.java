package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1337_D1_A {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int dep[], size[];

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt()-1;
            int y = scanner.nextInt()-1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dep = new int[n];
        size = new int[n];
        dfs(0, -1);
        for (int i = 0; i < n; i++) dep[i] = dep[i] - size[i] + 1;
       Arrays.sort(dep);
        long sum = 0;
        for (int i = dep.length - 1; i >= dep.length - k; i--) sum += dep[i];
        System.out.println(sum);
//        int[] parent = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//        boolean[] visited = new boolean[n + 1];
//        int[] dist = new int[n + 1];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        dist[1] = 0;
//        parent[1] = 0;
//        while (!list.isEmpty()) {
//            int curr = list.pollFirst();
//            visited[curr] = true;
//            for (int x : graph.get(curr)) {
//                if (!visited[x]) {
//                    list.add(x);
//                    dist[x] = Math.min(dist[x], dist[curr] + 1);
//                    parent[x] = curr;
//                }
//            }
//        }
//        int[] count = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            int index = parent[i];
//            while (index != 0) {
//                count[index]++;
//                index = parent[index];
//            }
//        }
//        ArrayList<Item> items = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            items.add(new Item(i, count[i]));
//        }
//        Collections.sort(items);
////        System.out.println(items);
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0 , j = n-1 ; i < k; i++, j--) {
//            set.add(items.get(j).index);
//        }
//        int ans = 0;
//        for (int i = 0; i < k; i++) {
//            int index = items.get(i).index;
//            while (index != 0) {
//                if (!set.contains(index))
//                    ans++;
//                index = parent[index];
//            }
//        }
//        System.out.println(ans);
//        System.out.println(count);
//        ArrayList<Item> items = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            items.add(new Item(i, dist[i]));
//        }
//        Collections.sort(items);
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < k; i++) {
//            set.add(items.get(i).index);
//        }
//        int count = 0;
//        for (int i = 0; i < k; i++) {
//            int index = items.get(i).index;
//            while (index != 0) {
//                if(!set.contains(index))
//                count++;
//                index = parent[index];
//            }
//        }
//        System.out.println(count);
    }

    static void dfs(int start, int pre) {
        size[start]++;
        for (int i : graph.get(start)) {
            if (i != pre) {
                dep[i] = dep[start] + 1;
                dfs(i, start);
                size[start] += size[i];
            }
        }
    }

    static class Item implements Comparable<Item> {
        int index, dist;

        public Item(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(o.dist, dist);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "index=" + index +
                    ", dist=" + dist +
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
