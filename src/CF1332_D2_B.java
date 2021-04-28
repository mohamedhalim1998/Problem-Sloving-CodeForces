import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class CF1332_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i < 32; i++) {
            if (isPrime(i)) {
                set.add(i);
            }
        }
        for (int i = 0; i < t; i++) {
            solve(scanner, set);
        }
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void solve(FastScanner scanner, HashSet<Integer> set) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int i = 0;
        int m = 1;
        int[] res = new int[n];
        int[] temp = new int[50];
        for (int x : arr) {
            for (int k : set) {
                if (x % k == 0) {
                    if (temp[k] == 0)
                        temp[k] = m++;
                    res[i++] = temp[k];
                    break;

                }
            }
        }
        System.out.println(--m);
        for (i = 0; i < n; i++) {

            System.out.print((res[i]) + " ");
        }
        System.out.println();
//        int[] div = new int[10001];
//        for (int x : arr) {
//            ArrayList<Integer> list = primeFactors(x);
//            for (int a : list) {
//                div[a]++;
//            }
//        }
//        ArrayList<Pair> pairs = new ArrayList<>();
//        for (int i = 0; i < div.length; i++) {
//            if (div[i] > 0) {
//                pairs.add(new Pair(i, div[i]));
//            }
//        }
//        int m = 1;
//        int[] res = new int[n];
//        int count = 0;
//        Collections.sort(pairs);
//        boolean used = false;
//        for (Pair p : pairs) {
//            if (count == n) {
//                break;
//            }
//            used = false;
//            for (int i = 0; i < n; i++) {
//                if (res[i] == 0 && arr[i] % p.index == 0) {
//                    res[i] = m;
//                    count++;
//                    used = true;
//                }
//            }
//            if (used) {
//                m++;
//            }
//        }
//        if (used)
//            System.out.println(--m);
//        else
//            System.out.println(m);
//        for (int i = 0; i < n; i++) {
//            System.out.print(res[i] + " ");
//        }
//        System.out.println();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int m = 1;
//        map.put(arr[0], 1);
//        StringBuilder out = new StringBuilder();
//        out.append(1).append(' ');
//        for (int i = 1; i < n; i++) {
//            boolean found = false;
//            for (Map.Entry<Integer, Integer> x : map.entrySet()) {
//                int gcd = gcd(x.getKey(), arr[i]);
//                if (gcd > 1) {
//                    out.append(x.getValue()).append(' ');
//                    found = true;
//                    map.remove(x.getKey());
//                    map.put(gcd, x.getValue());
//                    break;
//                }
//            }
//            if (!found) {
//                m++;
//                out.append(m).append(' ');
//                map.put(arr[i], m);
//            }
//        }
//        System.out.println(m);
//        System.out.println(out);
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static class Pair implements Comparable<Pair> {
        int index, value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(pair.value, value);
        }
    }

    public static ArrayList<Integer> primeFactors(int numbers) {
        int n = numbers;
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
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