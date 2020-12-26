package B;

import java.util.ArrayList;
import java.util.Scanner;

public class CF1455_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int x = scanner.nextInt();

        int sum = 0;
        int count = 0;
        int i = 1;
        while (sum < x) {
            sum += i;
            count++;
            i++;
        }
        if (sum == x) {
            System.out.println(count);
        } else {
            if(sum == x + 1){
                System.out.println(++count);
            } else {
                System.out.println(count);
            }
        }
    }

}
