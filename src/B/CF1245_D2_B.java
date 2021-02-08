package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF1245_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', a);
        map.put('P', b);
        map.put('S', c);
        String s = scanner.next();
        int count = 0;
        char[] arr = new char[n];
        Arrays.fill(arr, ' ');
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                if (map.get('P') > 0) {
                    map.put('P', map.get('P') - 1);
                    count++;
                    arr[i] = 'P';
                }
            } else if (ch == 'P') {
                if (map.get('S') > 0) {
                    map.put('S', map.get('S') - 1);
                    count++;
                    arr[i] = 'S';
                }
            } else if (ch == 'S') {
                if (map.get('R') > 0) {
                    map.put('R', map.get('R') - 1);
                    count++;
                    arr[i] = 'R';
                }
            }
            i++;
        }
        if (count >= (n + 1) / 2) {
            out.append("YES\n");
            for (int j = 0; j < n; j++) {
                if (arr[j] == ' ') {
                    if (map.get('R') > 0) {
                        map.put('R', map.get('R') - 1);
                        arr[j] = 'R';
                    } else if (map.get('P') > 0) {
                        map.put('P', map.get('P') - 1);
                        arr[j] = 'P';
                    } else if (map.get('S') > 0) {
                        map.put('S', map.get('S') - 1);
                        arr[j] = 'S';
                    }
                }
            }
            out.append(arr).append('\n');
        } else {
            out.append("NO\n");
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