package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF190_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            list.add(s);
            if(s.equals("int")){
                count++;
            }
        }
        if(n == 1 && list.size() > 1){
            System.out.println("Error occurred");

            return;
        }
        StringBuilder out = new StringBuilder();
        int index = solve(list, out, 0);
        if (index == -1 || index != list.size() - 1)
            System.out.println("Error occurred");
        else
            System.out.println(out);

    }

    private static int solve(ArrayList<String> list, StringBuilder out, int curr) {
        if(list.get(curr).equals( "int")){
            out.append("int");
            return curr;
        }
        if(curr+1 >= list.size()){
            return -1;
        }
        out.append("pair<");
        int next = solve(list, out, curr + 1);
        if(next == -1|| next == list.size() - 1){
            return -1;
        }
        out.append(",");
        next = solve(list, out, next + 1);
        if(next == -1){
            return -1;
        }


        out.append(">");

        return next;

//        return 0;
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
    }}
