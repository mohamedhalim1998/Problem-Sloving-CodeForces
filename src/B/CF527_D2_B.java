package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF527_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        HashMap<Character, ArrayList<Integer>> mapS = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> mapT = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
//                set.add(i);
                ArrayList<Integer> list = mapS.getOrDefault(s.charAt(i), new ArrayList<>());
                list.add(i);
                mapS.put(s.charAt(i), list);
                list = mapT.getOrDefault(t.charAt(i), new ArrayList<>());
                list.add(i);
                mapT.put(t.charAt(i), list);
            }
        }
        int a = -1;
        int b = -1;
        int c = 0;
        for (Map.Entry<Character, ArrayList<Integer>> e : mapS.entrySet()) {
            if (mapT.containsKey(e.getKey())) {
                c++;
                if (c == 1) {
                    a = e.getValue().get(0) + 1;
                    b = mapT.get(e.getKey()).get(0) + 1;
                }
//                set.add(e.getKey());
            }
        }
        if (c >= 2) {
//            System.out.println(count - 2);
            for (Map.Entry<Character, ArrayList<Integer>> e : mapS.entrySet()) {
                if (mapT.containsKey(e.getKey())) {
                    for (int x : e.getValue()) {
                        for (int y : mapT.get(e.getKey())) {
                            if (s.charAt(x) == t.charAt(y) && s.charAt(y) == t.charAt(x)) {
                                System.out.println(count - 2);
                                System.out.println((x + 1) + " " + (y + 1));
                                return;
                            } else if (s.charAt(x) == t.charAt(y) || s.charAt(y) == t.charAt(x)) {
                                a = x + 1;
                                b = y + 1;
                            }
                        }
                    }
                }
            }
            System.out.println(count - 1);
        } else if (c > 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
        System.out.println(a + " " + b);

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