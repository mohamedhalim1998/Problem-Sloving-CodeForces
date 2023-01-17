package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF329_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.next().toCharArray();
        }
        boolean foundRow = false;

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == '.') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                foundRow = true;
                break;
            }
        }
        boolean foundCol = false;

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (mat[j][i] == '.') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                foundCol = true;
                break;
            }
        }
        if (foundRow && foundCol) {
            System.out.println(-1);
            return;
        }

        StringBuilder out = new StringBuilder();
        if(foundRow){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[j][i] == '.') {
                        out.append(j + 1).append(' ').append(i + 1).append('\n');
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == '.') {
                        out.append(i + 1).append(' ').append(j + 1).append('\n');
                        break;
                    }
                }
            }
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
    }
}
