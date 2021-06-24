package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1102_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Element[] arr = new Element[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Element(i, scanner.nextInt());
        }
        int[] res = new int[n];
        Arrays.sort(arr);
        res[arr[0].index] = 1;
        int curr = 1;
        int c = 1;
        boolean done = false;
        for (int i = 1; i < n; i++) {
            curr++;
            if (curr >= k) {
                done = true;
            }
            if (curr > k) {
                curr -= k;
            }
            if (arr[i].val == arr[i - 1].val) {
                c++;
                if (c > k) {
                    System.out.println("NO");
                    return;
                }
            } else {
                c = 1;
            }
            res[arr[i].index] = curr;
        }

        if (curr >= k) {
            done = true;
        }
        if (!done) {
            System.out.println("NO");
            return;
        }
        StringBuilder out = new StringBuilder();
        out.append("YES\n");
        for (int x : res) {
            out.append(x).append(' ');
        }
        System.out.println(out);
    }

    static class Element implements Comparable<Element> {
        int index;
        int val;

        public Element(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Element element) {
            return Integer.compare(val, element.val);
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