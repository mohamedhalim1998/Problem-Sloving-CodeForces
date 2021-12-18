package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF901_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n + 1);
        StringBuilder out = new StringBuilder();
        out.append("ambiguous\n");
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(0);
        two.add(0);
        parent.add(1);
        boolean change = false;
        int index = 2;
        for (int i = 1; i <= n; i++) {
            if (parent.size() > 1 && arr[i] > 1) {
                change = true;
                one.add(parent.get(0));
                two.add(parent.get(1));
                for (int j = 1; j < arr[i]; j++) {
                    one.add(parent.get(0));
                    two.add(parent.get(0));
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    one.add(parent.get(0));
                    two.add(parent.get(0));
                }
            }
            parent = new ArrayList<>();
            for (int j = 0; j < arr[i]; j++) {
                parent.add(index++);
            }

        }
        if (!change) {
            System.out.println("perfect");
            return;
        }
        for (int x : one) {
            out.append(x).append(' ');
        }
        out.append('\n');
        for (int x : two) {
            out.append(x).append(' ');
        }
        System.out.println(out);
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