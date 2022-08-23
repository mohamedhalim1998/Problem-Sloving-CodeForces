package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF141_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Person[] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Person(scanner.next(), scanner.nextInt());
        }
        Arrays.sort(arr);
        Person[] out = new Person[n];
        int h = 1;
        out[0] = new Person(arr[0].name, h);
        for (int i = 1; i < n; i++) {
            if (arr[i].a > 0) {
                int a = h -  arr[i].a + 1;
                if (a == 0) {
                    System.out.println(-1);
                    return;
                }

                change(out, a);
                out[i] = new Person(arr[i].name, a);
            } else {
                out[i] = new Person(arr[i].name, h + 1);
            }
            h += 10;
        }
        for (Person p : out) {
            System.out.println(p);
        }

    }

    private static void change(Person[] out, int a) {
        for (Person person : out) {
            if (person != null && person.a >= a) {
                person.a += 1;
            }
        }
    }

    static class Person implements Comparable<Person> {
        String name;
        int a;

        public Person(String name, int a) {
            this.name = name;
            this.a = a;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(a, o.a);
        }

        @Override
        public String toString() {
            return name + " " + a;
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
