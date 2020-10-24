package B;

import java.util.Scanner;

public class CF467_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] players = nextArray(scanner, m);
        int count = 0;
        int f = scanner.nextInt();
        for (int p : players) {
            if (compareString(Integer.toBinaryString(p), Integer.toBinaryString(f)) <= k) {
                count++;
            }
        }
        System.out.println(count);

    }

    private static int compareString(String s1, String s2) {
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        StringBuilder builder = new StringBuilder(s2);
        for (int i = s2.length(); i < s1.length(); i++) {
            builder.insert(0, 0);
        }
        s2 = builder.toString();
        int ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ans++;
            }
        }

        return ans;
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
