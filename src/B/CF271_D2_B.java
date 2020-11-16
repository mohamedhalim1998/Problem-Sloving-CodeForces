package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF271_D2_B {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int[][] primes = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map.containsKey(matrix[i][j])) {
                    int count = 0;
                    int x = matrix[i][j];
                    while (!isPrime(x)) {
                        count++;
                        x++;
                    }
                    map.put(matrix[i][j], count);
                }
                primes[i][j] = map.get(matrix[i][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        int[] rows = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[i] += primes[i][j];
            }
            if (min > rows[i]) {
                min = rows[i];
                if (min == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }
        int[] cols = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[i] += primes[j][i];
            }
            if (min > cols[i]) {
                min = cols[i];
                if (min == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(min);


    }

    static boolean isPrime(int m) {
        if (m == 1) {
            return false;
        }
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    }

}
