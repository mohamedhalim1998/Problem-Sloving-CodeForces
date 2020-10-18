package B;

import java.util.Scanner;

public class CF102_D2_B {
    // time reading 3 min
    // think 3 min
    // implement time 3 min
    // debug 0 min
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(calculateSum(s));
    }
    static int calculateSum(String s){
        if(s.length() == 1){
            return 0;
        }
        int sum = 0;
        for (char c : s.toCharArray()) {
             sum += Character.getNumericValue(c);
        }
        return 1 + calculateSum("" + sum);
    }
}

