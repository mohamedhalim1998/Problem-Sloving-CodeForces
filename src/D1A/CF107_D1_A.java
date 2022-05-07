package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF107_D1_A {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < p; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int d = scanner.nextInt();
            graph.get(a).add(new Edge(b, d));
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!isCyclic(i)) {
                boolean[] visited = new boolean[n];
                dfs(i, visited, i, parent);
            } else {
                parent[i] = -1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                list.add(i);
            }
        }
        boolean[] visited = new boolean[n];
        ArrayList<Tank> res = new ArrayList<>();
        for (int x : list) {
            dfs(x, visited, res);
        }
        System.out.println(res.size());
        for(Tank tank : res){
            out.append(tank);
        }
        System.out.println(out);


    }

    private static void dfs(int i, boolean[] visited, int p, int[] parent) {
        if (!visited[i]) {
            visited[i] = true;
            if (i != p)
                parent[i] = p;
        }
        for (Edge x : graph.get(i)) {
            if (!visited[x.n]) {
                dfs(x.n, visited, i, parent);
            }
        }

    }

    private static void dfs(int i, boolean[] visited, ArrayList<Tank> res) {
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        int s = i;
        int e = i;
        int d = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited[curr] = true;
            e = curr;
            for (Edge edge : graph.get(curr)) {
                if (!visited[edge.n]) {
                    stack.push(edge.n);
                    d = Math.min(d, edge.d);
                }
            }
        }
        if (s != e) {
            res.add(new Tank(s + 1, e + 1, d));
        }
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
        List<Edge> children = graph.get(i);

        for (Edge c : children)
            if (isCyclicUtil(c.n, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }


    private static boolean isCyclic(int x) {


        boolean[] visited = new boolean[graph.size()];
        boolean[] recStack = new boolean[graph.size()];


        return isCyclicUtil(x, visited, recStack);

    }

    static class Tank {
        int s, e, d;

        public Tank(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public String toString() {
            return s + " " + e + " " + d + "\n";
        }
    }


    static class Edge {
        int n;
        int d;

        public Edge(int n, int d) {
            this.n = n;
            this.d = d;
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