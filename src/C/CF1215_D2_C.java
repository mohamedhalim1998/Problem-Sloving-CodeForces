package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class
CF1215_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        ArrayList<Integer> toA = new ArrayList<>();
        ArrayList<Integer> toB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.charAt(i) == 'a') {
                    toB.add(i + 1);
                } else {
                    toA.add(i + 1);
                }
            }
        }
        if (toA.size() % 2 != toB.size() % 2) {
            System.out.println(-1);
            return;
        }
        int count = 0;
        StringBuilder out = new StringBuilder();
        if (toB.size() % 2 == 1) {
            count += 2;
            out.append(toB.get(0)).append(' ').append(toB.get(0)).append('\n');
            out.append(toB.get(0)).append(' ').append(toA.get(0)).append('\n');
            for (int i = 1; i + 1 < toA.size(); i += 2) {
                out.append(toA.get(i)).append(' ').append(toA.get(i + 1)).append('\n');
                count++;
            }
            for (int i = 1; i + 1 < toB.size(); i += 2) {
                out.append(toB.get(i)).append(' ').append(toB.get(i + 1)).append('\n');
                count++;
            }
        } else {
            for (int i = 0; i + 1 < toA.size(); i += 2) {
                out.append(toA.get(i)).append(' ').append(toA.get(i + 1)).append('\n');
                count++;
            }
            for (int i = 0; i + 1 < toB.size(); i += 2) {
                out.append(toB.get(i)).append(' ').append(toB.get(i + 1)).append('\n');
                count++;
            }
        }

        System.out.println(count);
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
    }
}