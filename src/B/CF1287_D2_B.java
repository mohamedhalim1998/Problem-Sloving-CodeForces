package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1287_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(arr).subList(0, n));


        long count = 0;
        for (int i = 0; i < n; i++) {
            String a = arr[i];
            for (int j = i + 1; j < n; j++) {
                String b = arr[j];
                StringBuilder c = new StringBuilder();
                for (int m = 0; m < k; m++) {
                    boolean ab = a.charAt(m) == b.charAt(m);
                    if (ab) {
                        c.append(b.charAt(m));
                    } else {
                        // E, T , S
                        if (a.charAt(m) == 'S') {
                            if (b.charAt(m) == 'E') {
                                c.append('T');
                            } else {
                                c.append('E');
                            }
                        } else if (a.charAt(m) == 'E') {
                            if (b.charAt(m) == 'S') {
                                c.append('T');
                            } else {
                                c.append('S');
                            }
                        } else if (a.charAt(m) == 'T') {
                            if (b.charAt(m) == 'E') {
                                c.append('S');
                            } else {
                                c.append('E');
                            }
                        }
                    }

                }

                if (set.contains(c.toString())) {
                    count++;
                }

            }
        }
        System.out.println(count / 3);

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