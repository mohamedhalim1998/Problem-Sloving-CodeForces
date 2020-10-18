package A;

import java.util.Scanner;

public class CF431_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 1 min
        // implement time 3 min
        // debug time 2 min
        Scanner scanner = new Scanner(System.in);
        int[] calories = new int[4];
        for(int i = 0; i < 4 ; i++){
            calories[i] = scanner.nextInt();
        }
        String values = scanner.next();
        int sum = 0;
        for (char c : values.toCharArray()) {
            sum += calories[Character.getNumericValue(c) - 1];
        }

        System.out.println(sum);
    }
}
