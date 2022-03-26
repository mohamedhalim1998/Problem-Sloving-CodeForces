package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF24_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        HashMap<String, Driver> map = new HashMap<>();
        int[] scores = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                String s = scanner.next();
                Driver driver = map.getOrDefault(s, new Driver(s));
                if (j < 10) {
                    driver.score += scores[j];
                }
                driver.rank[j]++;
                map.put(s, driver);
            }
        }
        ArrayList<Driver> list = new ArrayList<>(map.values());
        // first system
        Collections.sort(list, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                if (d1.score != d2.score) {
                    return Integer.compare(d2.score, d1.score);
                } else {
                    for (int i = 0; i < 50; i++) {
                        if (d1.rank[i] != d2.rank[i]) {
                            return Integer.compare(d2.rank[i], d1.rank[i]);
                        }
                    }
                }
                return 0;
            }
        });
        System.out.println(list.get(0));

        // second system
        Collections.sort(list, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                if (d1.rank[0] != d2.rank[0]) {
                    return Integer.compare(d2.rank[0], d1.rank[0]);
                } else if (d1.score != d2.score) {
                    return Integer.compare(d2.score, d1.score);
                } else {
                    for (int i = 1; i < 50; i++) {
                        if (d1.rank[i] != d2.rank[i]) {
                            return Integer.compare(d2.rank[i], d1.rank[i]);
                        }
                    }
                }
                return 0;
            }
        });
        System.out.println(list.get(0));

    }

    static class Driver {
        int score;
        String name;
        int[] rank = new int[50];

        public Driver(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Driver driver = (Driver) o;
            return Objects.equals(name, driver.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return name;
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
