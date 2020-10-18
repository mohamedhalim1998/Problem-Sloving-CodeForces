package B;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CF253_D2_B {
    private static int n;
    //  private static int[] res;
    private static int[] m;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter("output.txt");
        //Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = new int[5001];
        HashSet<Integer> arr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr.add(x);
            m[x]++;
        }
//        Arrays.sort(m);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 5000; i++) {
            int count = 0;
            for (int j : arr) {
                if (j < i || j > 2 * i) {
                    count += m[j];
                }
            }
            if (count < min) {
                min = count;
            }

        }

        //System.out.println(min);
          writer.print("" + min);

        writer.close();
    }

    static int solve(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (m[y] <= 2 * m[x]) {
            return 0;
        }
        int r = Integer.MAX_VALUE;

        if (m[y - 1] - m[x] < m[y] - m[x + 1]) {
            r = Math.min(r, 1 + solve(x, y - 1));
        } else if (m[y - 1] - m[x] == m[y] - m[x + 1]) {
            r = Math.min(r, 1 + solve(x + 1, y));
            r = Math.min(r, 1 + solve(x, y - 1));

        } else {
            r = Math.min(r, 1 + solve(x + 1, y));
        }


        return r;

    }
}
