package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1427_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        ArrayList<Integer> list = new ArrayList<>();
        char curr = 'W';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == curr) {
                count++;
            } else {
                list.add(count);
                curr = c;
                count = 1;
            }
        }

        list.add(count);
        if (list.size() % 2 == 0) {
            list.add(0);
        }
        int w = 0;
        int l = 0;
        int wins = 0;
        ArrayList<Integer> loses = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                continue;
            }
            if (i % 2 == 0) {
                w += list.get(i);
                wins++;
            } else {
                loses.add(list.get(i));
                l += list.get(i);
            }
        }
        if (l <= k) {
            System.out.println(2 * n - 1);
            return;
        }
        if (w == 0) {
            if (k == 0) System.out.println(0);
            else System.out.println(2 * k - 1);
            return;
        }
        if (s.charAt(0) == 'L') loses.set(0, (int) 1e8);
        if (s.charAt(n - 1) == 'L') loses.set(loses.size() - 1, (int) 1e8);
        Collections.sort(loses);
        w += k;
        for (int x : loses) {
            if (x > k) {
                break;
            }
            wins--;
            k -= x;
        }
        System.out.println(2 * w - wins);

//        while (k > 0) {
//            if (list.size() == 1) {
//                System.out.println(n * 2 - 1);
//                return;
//            }
//            int max = -1;
//            int index = -1;
//            int min = Integer.MAX_VALUE;
//            for (int i = 1; i < list.size() - 1; i += 2) {
//                if (list.get(i) <= k) {
//                    if (list.get(i) < min) {
//                        min = list.get(i);
//                        index = i;
//                        int sum = list.get(i - 1) + list.get(i + 1);//+ list.get(i);
//                        max = Math.max(sum, max);
//                    } else if (list.get(i) == min) {
//                        int sum = list.get(i - 1) + list.get(i + 1);//+ list.get(i);
//                        if (sum > max) {
//                            min = list.get(i);
//                            index = i;
//                            max = Math.max(sum, max);
//
//                        }
//
//                    }
//                }
//            }
//            if (index == -1) {
//                break;
//            }
//            ArrayList<Integer> newList = new ArrayList<>();
//            k -= list.get(index);
//            for (int i = 0; i < list.size(); i++) {
//                if (i != index) {
//                    newList.add(list.get(i));
//                } else {
//                    newList.set(i - 1, newList.get(i - 1) + list.get(i) + list.get(i + 1));
//                    i++;
//                }
//            }
//            list = newList;
//            if (list.size() % 2 == 0) {
//                list.add(0);
//            }
//        }
//        int max = -1;
//        int sum = 0;
//        for (int i = 0; i < list.size(); i += 2) {
//            if (list.get(i) == 0) {
//                continue;
//            }
//            sum += list.get(i) * 2 - 1;
//            max = Math.max(max, list.get(i));
//        }
//        if (sum == 0 && k > 0) {
//            System.out.println(k * 2 - 1);
//            return;
//        }
//        System.out.println(sum + k * 2);
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