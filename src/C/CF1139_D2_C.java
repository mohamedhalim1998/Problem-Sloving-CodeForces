package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1139_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static  long mod = (long) (1e9 + 7);
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            int e = scanner.nextInt();
            if (e == 0) {
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
        }
        boolean[] visited = new boolean[n];
        long s = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int p = dfs(visited, i);
                s += pow(p, k , mod);
//                if(s > mod){
//                    s %= mod;
//                }
            }
        }
        s = s % mod;
        long ans = pow(n, k, mod) - s + mod;
        System.out.println(ans % mod);

    }

    private static int dfs(boolean[] visited, int i) {
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        int count = 0;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
//            if (!visited[curr]) {
                visited[curr] = true;
                count++;
                for (int x : graph.get(curr)) {
                    if (!visited[x]) {
                        stack.add(x);
                    }
                }
//            }
        }
        return count;
    }
    public static long pow(long a, int b, long m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long res = pow(a, b / 2, m);
            return (res * res) % m;
        } else {
            return (pow(a, b - 1, m) * a) % m;
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