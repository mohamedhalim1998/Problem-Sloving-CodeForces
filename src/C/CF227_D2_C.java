package C;

import java.util.Scanner;

public class CF227_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long count = pow(3, n, m) - 1;
        if(count == -1){
            count = m - 1;
        }
        System.out.println(count % m);
    }

    public static long pow(long a, int b, int m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long res = pow(a, b / 2, m);
            return (res * res) % m;
        } else {
            return (pow(a, b - 1, m) * a) % m;
        }
    }
}
