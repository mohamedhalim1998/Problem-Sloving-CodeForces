package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class
CF705_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        HashMap<Integer, ArrayList<Integer>> app = new HashMap<>();
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int count = 0;
        int last = 0;
        StringBuilder out = new StringBuilder();
        int[] arr = new int[q];
        int index = 0;
        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            if (t == 1) {
                ArrayList<Integer> list = app.getOrDefault(x, new ArrayList<>());
                list.add(index);
                app.put(x, list);
                count++;
                arr[index++] = x;
            } else if (t == 2) {
                ArrayList<Integer> list = app.getOrDefault(x, new ArrayList<>());
                count = Math.max(count, 0);
                app.put(x, new ArrayList<>());
                for (int a : list) {
                    arr[a] = 0;
                    if(a >= last) {
                        count--;
                    }
                }
            } else {
                for (int j = last; j < x; j++) {
                    if (arr[j] != 0) {
                        count--;
                    }
                    count = Math.max(count, 0);
                }
                last = Math.max(last, x);
            }
            out.append(count).append('\n');
        }
        System.out.println(out);

    }

    static class Notification {
        int app;
        boolean read;

        public Notification(int app) {
            this.app = app;
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
