package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF195_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int depth = 0;
        String error = "";
        int eDepth = -1;
        int skip = 0;
        StringBuilder out = new StringBuilder();
//        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.equals("try")) {
                if (error.equals("")) {
                    depth++;
                } else {
                    skip++;
                }
            } else if (line.contains("throw")) {
//                throw ( AE )
                error = line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim();
                eDepth = depth;
            } else if (line.contains("catch")) {
                // catch(BE, "BE in line 5")
                if (skip > 0) {
                    skip--;
                    continue;
                }
                depth--;
                if (!error.equals("")) {
                    String type = line.substring(line.indexOf('(') + 1, line.indexOf(',')).trim();
                    if (error.equals(type) && eDepth > depth) {
                        out.append(line, line.indexOf('"') + 1, line.lastIndexOf('"'));
                        skip = 0;
                        eDepth = 0;
                        error = "";
                    }
                }
            }
        }
        if(!error.equals("")) {
            System.out.println("Unhandled Exception");
            return;
        }
        System.out.println(out);

    }

//    static class Error {
//        String type;
//        int depth;
//
//        public Error(String type, int depth) {
//            this.type = type;
//            this.depth = depth;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Error error = (Error) o;
//            return depth == error.depth && Objects.equals(type, error.type);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(type, depth);
//        }
//    }

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
