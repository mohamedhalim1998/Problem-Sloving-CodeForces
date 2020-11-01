package C;

import java.util.ArrayList;
import java.util.Scanner;

public class CF577_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                for (int j = i; j <= n; j *= i) {
                    list.add(j);
                }
            }
        }
        System.out.println(list.size());
        for(int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

}
