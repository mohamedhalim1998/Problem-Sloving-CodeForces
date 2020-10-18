package A;

import java.util.Scanner;

public class CF1327_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        long k = scanner.nextInt();
        k = k * k;
        if(n < k){
            System.out.println("NO");
            return;
        }
        if(n % 2 != k % 2){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");;


    }
}
