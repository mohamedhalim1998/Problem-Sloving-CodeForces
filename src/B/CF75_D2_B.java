package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF75_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        User mine = new User(scanner.next());
        HashMap<String, Integer> map = new HashMap<>();
        map.put(mine.name, 0);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            if (s.contains(" likes ")) {
                String[] arr = s.split(" likes ");
                String u1 = arr[0];
                String u2 = arr[1].split("'s")[0];

                map.put(u1, map.getOrDefault(u1, 0));
                map.put(u2, map.getOrDefault(u2, 0));
                if (u1.equals(mine.name) || u2.equals(mine.name)) {
                    map.put(u1, map.get(u1) + 5);
                    map.put(u2, map.get(u2) + 5);
                }
            } else if (s.contains(" commented on ")) {
                String[] arr = s.split(" commented on ");
                String u1 = arr[0];
                String u2 = arr[1].split("'s")[0];

                map.put(u1, map.getOrDefault(u1, 0));
                map.put(u2, map.getOrDefault(u2, 0));
                if (u1.equals(mine.name) || u2.equals(mine.name)) {
                    map.put(u1, map.get(u1) + 10);
                    map.put(u2, map.get(u2) + 10);
                }
            } else if (s.contains(" posted on ")) {
                String[] arr = s.split(" posted on ");
                String u1 = arr[0];
                String u2 = arr[1].split("'s")[0];

                map.put(u1, map.getOrDefault(u1, 0));
                map.put(u2, map.getOrDefault(u2, 0));
                if (u1.equals(mine.name) || u2.equals(mine.name)) {
                    map.put(u1, map.get(u1) + 15);
                    map.put(u2, map.get(u2) + 15);
                }
            }
        }
        ArrayList<User> users = new ArrayList<>();
        for(String name : map.keySet()){
            users.add(new User(name, map.getOrDefault(name, 0)));
        }
        Collections.sort(users);
        for (User u : users) {
            if (!u.equals(mine)) {
                System.out.println(u.name);
            }
        }


    }

    static class User implements Comparable<User> {
        String name;
        int p;

        public User(String name) {
            this.name = name;
        }

        public User(String name, int p) {
            this.name = name;
            this.p = p;
        }

        @Override
        public int compareTo(User user) {
            if (user.p != p) return Integer.compare(user.p, p);
            return name.compareTo(user.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
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
