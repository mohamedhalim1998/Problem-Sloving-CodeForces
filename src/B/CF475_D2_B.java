package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF475_D2_B {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph.add(new ArrayList<>());
            }
        }
        String ver = scanner.next();
        String hor = scanner.next();
        for (int i = 0; i < n; i++) {
            if (ver.charAt(i) == '>') {
                for (int j = 0; j < m - 1; j++) {
                    graph.get(i * m + j).add(i * m + j + 1);
                }
            } else {
                for (int j = m - 1; j > 0; j--) {
                    graph.get(i * m + j).add(i * m + j - 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (hor.charAt(i) == 'v') {
                for (int j = 0; j < n - 1; j++) {
                    graph.get(j * m + i).add((j + 1) * m + i);
                }
            } else {
                for (int j = n - 1; j > 0; j--) {
                    graph.get(j * m + i).add((j - 1) * m + i);
                }
            }
        }
        for (int i = 0; i < graph.size(); i++) {


            boolean[] visited = new boolean[n * m];
            Stack<Integer> stack = new Stack<>();
            stack.add(i);
            while (!stack.isEmpty()) {
                int c = stack.pop();
                visited[c] = true;
                for (int x : graph.get(c)) {
                    if (!visited[x]) {
                        stack.add(x);
                    }
                }
            }
            for (boolean b : visited) {
                if (!b) {
                 //   System.out.println(i);
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");


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