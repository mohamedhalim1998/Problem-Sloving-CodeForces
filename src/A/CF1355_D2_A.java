package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF1355_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        long num = scanner.nextLong();
        char[] n = String.valueOf(num).toCharArray();
        long k = scanner.nextLong();
        Arrays.sort(n);
        for (long i = 0; i < k - 1; i++) {
           num = num + Character.getNumericValue(n[0]) * Character.getNumericValue(n[n.length - 1]);
            n = String.valueOf(num).toCharArray();
            Arrays.sort(n);
            if(n[0] == '0'){
                break;
            }
        }
        System.out.println(num);
    }
}
