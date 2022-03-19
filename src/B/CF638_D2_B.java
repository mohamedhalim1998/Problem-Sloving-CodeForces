package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF638_D2_B {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parent = new int[26];

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            for (int j = 0; j < s.length() - 1; j++) {
                graph.get(s.charAt(j) - 'a').add(s.charAt(j + 1) - 'a');
            }
        }
        Arrays.fill(parent, -1);
        for (char c : set) {
            parent[c - 'a'] = c - 'a';
        }

        for (char c : set) {
            int i = c - 'a';
            boolean[] visited = new boolean[26];
            dfs(i, visited, i);


        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (parent[i] == i) {
                list.add(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int x : list) {
            builder.append(dfs(x));
        }
        System.out.println(builder);

    }

    private static String dfs(int i) {
        boolean[] visited = new boolean[graph.size()];
        StringBuilder out = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                out.append((char) (curr + 'a'));
                visited[curr] = true;
            }
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.add(x);
                }
            }
        }
        return out.toString();
    }

    private static void dfs(int i, boolean[] visited, int p) {
        if (!visited[i]) {
            visited[i] = true;
            if (i != p)
                parent[i] = p;
        }
        for (int x : graph.get(i)) {
            if (!visited[x]) {
            dfs(x, visited, i);
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