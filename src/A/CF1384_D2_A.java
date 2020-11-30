package A;

import java.util.ArrayList;
import java.util.Scanner;

public class CF1384_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        ArrayList<String> out = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr[0]; i++) {
            builder.append('a');
        }
        out.add(builder.toString());
        char c = 'b';
        for (int i = 0; i < n; i++) {
            String s = out.get(i);
            StringBuilder s2 = new StringBuilder();
            if (s.length() > arr[i]) {
                for (int j = 0; j < arr[i]; j++) {
                    s2.append(s.charAt(j));
                }
                out.add(s2.toString());
            } else {
                c = (char) (c + 1);
                s2.append(s);
                StringBuilder s1 = new StringBuilder(s);
                for (int j = s.length(); j < arr[i]; j++) {
                    s2.append(c);
                    s1.append(c);
                }
                out.remove(i);
                out.add(s1.toString());
                out.add(s2.toString());
                if (c == 'x') {
                    c = 'a';
                }
            }
        }
        c = 'z';
        for (String s : out) {
            if (s.length() == 0) {
                System.out.println(c);
                if (c == 'z') {
                    c = 'y';
                } else {
                    c = 'z';
                }
            } else {
                System.out.println(s);
            }
        }
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
