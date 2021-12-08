package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF300_D2_B {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        LinkedList<ArrayList<Integer>> three = new LinkedList<>();
        LinkedList<ArrayList<Integer>> two = new LinkedList<>();
        LinkedList<ArrayList<Integer>> one = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> list = dfs(i, visited);
                if (list.size() == 3) {
                    three.add(list);
                } else if (list.size() == 2) {
                    two.add(list);
                } else if (list.size() == 1) {
                    one.add(list);
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (two.size() > one.size() || (one.size() - two.size()) % 3 != 0) {
            System.out.println(-1);
            return;
        }
        for (ArrayList<Integer> list : three) {
            printArrayInLine(list);
            System.out.println();
        }
        int twos = two.size();
        for (int i = 0; i < twos; i++) {
            printArrayInLine(two.poll());
            printArrayInLine(one.poll());
            System.out.println();
        }
        int ones = one.size();
        for (int i = 0; i < ones - 2; i+=3) {
            printArrayInLine(one.poll());
            printArrayInLine(one.poll());
            printArrayInLine(one.poll());
            System.out.println();

        }


    }

    public static void printArrayInLine(ArrayList<Integer> arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value + 1).append(" ");
        }
        System.out.print(builder);
    }

    private static ArrayList<Integer> dfs(int i, boolean[] visited) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                list.add(curr);
            }
            visited[curr] = true;
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.add(x);
                }
            }
        }
        return list;
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