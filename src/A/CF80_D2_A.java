package A;

import java.util.Scanner;

public class CF80_D2_A {
    public static void main(String[] args) {
        // reading time 3 min
        // think time 1 min
        // implement time 3 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(isPrime(m)){
            for( int i = n + 1; i < m ; i++){
                if(isPrime(i)){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");

        } else {
            System.out.println("NO");
        }


    }

    static boolean isPrime(int m) {
        for (int i = 2; i < m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}
