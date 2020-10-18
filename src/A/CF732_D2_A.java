package A;

import java.util.Scanner;

public class CF732_D2_A {
    public static void main(String[] args) {
        // reading time 3 min
        // think time 2 min
        // implement time 2 min
        // debug time 1 min
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int r = scanner.nextInt();
        int price = k;
        for (int i = 1; i <= 10; i++) {
            if(((price - r) % 10 == 0) || (price % 10 == 0)){
                System.out.print(i);
                break;
            }
            price += k;
        }
    }
}
