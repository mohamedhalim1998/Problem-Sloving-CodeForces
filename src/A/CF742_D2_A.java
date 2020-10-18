package A;

import java.util.Scanner;

public class CF742_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 5 min
        // implement time 1 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println("1");
            return;
        }
        int[] values = {8, 4, 2, 6};
        int i = (n % 4) - 1;
        if(i == -1){
            i = 3;
        }
        System.out.println(values[i]);
    }
}
