package A;

import java.util.Scanner;

public class CF263_D2_A {
    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 4 min
        // debug  0 min

        Scanner scanner = new Scanner(System.in);
        int index = -1;
        for (int i=0 ; i < 25 ; i++){
            int x = scanner.nextInt();
            if(x == 1){
                index = i;
                break;
            }
        }
        int swaps = Math.abs((index / 5) - 2) + Math.abs((index % 5) -2);
        System.out.println(swaps);
    }
}
