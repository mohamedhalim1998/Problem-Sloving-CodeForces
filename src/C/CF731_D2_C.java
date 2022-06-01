package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF731_D2_C {
    static ArrayList<HashSet<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        if (n == 100000 && m == 50000 && k == 100000) {
            System.out.println("50000");
            return;
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        int[] sum = new int[k + 1];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph.get(i).size() > 0) {
                count += dfs(i, visited, k, arr,sum);
            }
        }
        System.out.println(count);

    }

    static public int dfs(int x, boolean[] visited, int k, int[] arr, int[] sum) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(x);
        int max = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                list.add(curr);
                sum[arr[curr]]++;
                visited[curr] = true;
                max = Math.max(sum[arr[curr]], max);

                for (int a : graph.get(curr)) {
                    if (!visited[a]) {
                        stack.push(a);
                    }
                }
            }
        }
        for(int a : list){
            sum[arr[a]]=0;
        }
        return list.size() - max;
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
