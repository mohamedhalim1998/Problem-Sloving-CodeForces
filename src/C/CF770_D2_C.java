package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF770_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static HashSet<Integer> mainSet = new HashSet<>();
    static boolean loop = false;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] main = scanner.nextArray(k);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int x : main) {
            mainSet.add(x);
        }
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            for (int j = 0; j < t; j++) {
                int x = scanner.nextInt() - 1;
                graph.get(i).add(x);
            }
        }
        if (isCyclic(main)) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        topologicalSort(main, list);
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder();
        for (int item : list) {
            builder.append(item).append(' ');

        }
        System.out.println(list.size());
        System.out.println(builder);

    }

    private static boolean isCyclicUtil(int i, boolean[] visited,
                                        boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = graph.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }


    private static boolean isCyclic(int[] main) {


        boolean[] visited = new boolean[graph.size()];
        boolean[] recStack = new boolean[graph.size()];

        for (int i : main)
            if (isCyclicUtil(i-1, visited, recStack))
                return true;

        return false;
    }

    static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex
        for (Integer integer : graph.get(v)) {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }

    static void topologicalSort(int[] main, ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i : main)
            if (!visited[i - 1])
                topologicalSortUtil(i - 1, visited, stack);

        // Print contents of stack
        while (!stack.empty())
            list.add((stack.pop() + 1));
    }

    public static void dfs(int s, int curr, boolean[] visited, int level, Item[] items) {
        if (loop) {
            return;
        }
        visited[curr] = true;
        items[curr].level = Math.max(items[curr].level, level);
        for (int x : graph.get(curr)) {
            if (level != 0 && x == s) {
                loop = true;
                return;
            } else {
                dfs(s, x, visited, level + 1, items);
            }
        }
    }


    static class Item implements Comparable<Item> {
        int index;
        int level;

        public Item(int index, int level) {
            this.index = index;
            this.level = level;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(o.level, level);
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