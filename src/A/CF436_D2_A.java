package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF436_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayList<Candy> fruit = new ArrayList<>();
        ArrayList<Candy> caramel = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int h = scanner.nextInt();
            int m = scanner.nextInt();
            if (t == 0) {
                caramel.add(new Candy(h, m));
            } else {
                fruit.add(new Candy(h, m));
            }
        }

        Collections.sort(caramel);
        Collections.sort(fruit);
        ArrayList<Candy> fruit2 = new ArrayList<>(fruit);
        ArrayList<Candy> caramel2 = new ArrayList<>(caramel);
        boolean c = true;
        int newX = x;
        int count = 0;
        while (true) {
            if (c) {
                c = false;
                int index = lessSearch(caramel, newX + 1);
                if (index <= -1) {
                    break;
                } else {
                    newX += caramel.get(index).m;
                    caramel.remove(index);
                    count++;
                }
            } else {
                c = true;
                int index = lessSearch(fruit, newX + 1);
                if (index <= -1) {
                    break;
                } else {
                    newX += fruit.get(index).m;
                    fruit.remove(index);
                    count++;
                }

            }
        }
        c = false;
        newX = x;
        int count2 = 0;
        while (true) {
            if (c) {
                c = false;
                int index = lessSearch(caramel2, newX + 1);
                if (index <= -1) {
                    break;
                } else {
                    newX += caramel2.get(index).m;
                    caramel2.remove(index);
                    count2++;
                }
            } else {
                c = true;
                int index = lessSearch(fruit2, newX + 1);
                if (index <= -1) {
                    break;
                } else {
                    newX += fruit2.get(index).m;
                    fruit2.remove(index);
                    count2++;
                }

            }
        }
        System.out.println(Math.max(count, count2));

    }

    static int lessSearch(ArrayList<Candy> arr, int x) {

        int ans = -1;

        int index = 0;
        while (index < arr.size() && arr.get(index).h < x) {
            if (ans == -1) {
                ans = index;
            } else {
                if (arr.get(index).m > arr.get(ans).m) {
                    ans = index;
                }
            }
            index++;
        }
        return ans;
    }


    static class Candy implements Comparable<Candy> {
        int h, m;

        public Candy(int h, int m) {
            this.h = h;
            this.m = m;
        }

        @Override
        public int compareTo(Candy candy) {
            if (h != candy.h) {
                return Integer.compare(h, candy.h);
            } else {
                return Integer.compare(m, candy.m);
            }
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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}