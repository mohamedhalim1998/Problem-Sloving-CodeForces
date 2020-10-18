package C;

import java.util.Scanner;

public class CF978_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] rooms = new long[n];
        long l = 15218893751L;
        for (int i = 0; i < n; i++) {
            rooms[i] = scanner.nextLong();
        }
        long[] letters = new long[m];
        for (int i = 0; i < m; i++) {
            letters[i] = scanner.nextLong();
        }
        long sum = 0;
        for (int i = 0, j = 0; i < m && j < n; ) {
            if (sum + rooms[j] >= letters[i]) {

                System.out.println((j + 1) + " " + ((letters[i] - sum) % (rooms[j] + 1)));
                i++;
            } else {
                sum += rooms[j];
                j++;
            }


        }


    }
}
