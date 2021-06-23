package C;

import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1154_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int oa = scanner.nextInt();
        int ob = scanner.nextInt();
        int oc = scanner.nextInt();
        int min = Math.min(oa / 3, Math.min(ob / 2, oc / 2));
        long w = min * 7;
        long count = 0;
        oa -= min * 3;
        ob -= min * 2;
        oc -= min * 2;
        for (int i = 1; i <= 7; i++) {
            long l = 0;
            int a = oa;
            int b = ob;
            int c = oc;
            for (int j = i; j <= 7 + i; j++) {
                int d = j % 7;
                if (d == 0) {
                    d = 7;
                }
                switch (d) {
                    case 1:
                    case 4:
                        b--;
                        break;
                    case 2:
                    case 3:
                    case 6:
                        a--;
                        break;
                    default:
                        c--;
                }
                if (a >= 0 && b >= 0 && c >= 0) {
                    l++;
                } else {
                    break;
                }
            }
            count = Math.max(count, l);
        }
        System.out.println(count + w);
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