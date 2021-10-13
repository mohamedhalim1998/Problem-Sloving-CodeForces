package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1051_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        int d = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                count++;
            }
            if (e.getValue() > 2) {
                d++;
            }
        }
        if (count % 2 == 0) {
            int b = count / 2;
            char[] ans = new char[n];
            Arrays.fill(ans, 'A');
            for (int i = 0; i < n; i++) {
                if (b > 0 && map.get(arr[i]) == 1) {
                    ans[i] = 'B';
                    b--;
                }
            }
            System.out.println("YES\n" + String.valueOf(ans));
        } else if (d > 0) {
            int b = count / 2 + 1;
            char[] ans = new char[n];
            Arrays.fill(ans, 'A');
            for (int i = 0; i < n; i++) {
                if (b > 0 && map.get(arr[i]) > 2) {
                    ans[i] = 'B';
                    b--;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (b > 0 && map.get(arr[i]) == 1) {
                    ans[i] = 'B';
                    b--;
                }
            }
            System.out.println("YES\n" + String.valueOf(ans));
        } else {
            System.out.println("NO");
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