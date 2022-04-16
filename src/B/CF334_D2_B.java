package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF334_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        HashSet<Pair> pairs = new HashSet<Pair>();
        HashSet<Integer> setX = new HashSet<>();
        HashSet<Integer> setY = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            setX.add(x);
            setY.add(y);
            pairs.add(new Pair(x, y));
        }
        if (setX.size() < 3 || setY.size() < 3) {
            System.out.println("ugly");
            return;
        }
        ArrayList<Integer> listX = new ArrayList<>(setX);
        ArrayList<Integer> listY = new ArrayList<>(setY);
        Collections.sort(listX);
        Collections.sort(listY);
        for (int x1 = 0; x1 < listX.size(); x1++) {
            for (int x2 = x1 + 1; x2 < listX.size(); x2++) {
                for (int x3 = x2 + 1; x3 < listX.size(); x3++) {
                    for (int y1 = 0; y1 < listY.size(); y1++) {
                        for (int y2 = y1 + 1; y2 < listY.size(); y2++) {
                            for (int y3 = y2 + 1; y3 < listY.size(); y3++) {
                                if (pairs.contains(new Pair(listX.get(x2), listY.get(y2)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x1), listY.get(y1)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x1), listY.get(y2)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x1), listY.get(y3)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x2), listY.get(y1)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x2), listY.get(y3)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x3), listY.get(y1)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x3), listY.get(y2)))) {
                                    continue;
                                }
                                if (!pairs.contains(new Pair(listX.get(x3), listY.get(y3)))) {
                                    continue;
                                }
                                System.out.println("respectable");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("ugly");
//        Arrays.sort(pairs);
//        for (int i = 0; i < 8; i++) {
//            for (int j = i + 1; j < 8; j++) {
//                for (int k = 0; k < 8; k++) {
//                    if ((pairs[i].x != pairs[j].x && pairs[i].x != pairs[k].x && pairs[j].x != pairs[k].x) &&
//                            (pairs[i].y != pairs[j].y && pairs[i].y != pairs[k].y && pairs[j].y != pairs[k].y)) {
//                        if()
//                    }
//
//                }
//            }
//        }

    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (x != o.x) {
                return Integer.compare(x, o.x);
            } else {
                return Integer.compare(y, o.y);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
