package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF762_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int usb = scanner.nextInt();
        int ps2 = scanner.nextInt();
        int both = scanner.nextInt();
        ArrayList<Long> usbList = new ArrayList<>();
        ArrayList<Long> ps2List = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long c = scanner.nextLong();
            String t = scanner.next();
            if (t.equals("USB")) {
                usbList.add(c);
            } else {
                ps2List.add(c);
            }
        }
        Collections.sort(usbList);
        Collections.sort(ps2List);
        int count = 0;
        long cost = 0;
        int i = 0;
        for (; i < usbList.size() && i < usb; i++) {
            cost += usbList.get(i);
            count++;
        }
        int j = 0;
        for (; j < ps2List.size() && j < ps2; j++) {
            cost += ps2List.get(j);
            count++;
        }

        for (int k = 0; k < both && (i < usbList.size() || j < ps2List.size()); k++) {
            if (i < usbList.size() && j < ps2List.size()) {
                if (usbList.get(i) < ps2List.get(j)) {
                    cost += usbList.get(i);
                    count++;
                    i++;
                } else {
                    cost += ps2List.get(j);
                    count++;
                    j++;
                }
            } else if (i < usbList.size()) {
                cost += usbList.get(i);
                count++;
                i++;
            } else if (j < ps2List.size()) {
                cost += ps2List.get(j);
                count++;
                j++;
            }
        }
        System.out.println(count + " " + cost);


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