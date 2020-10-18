package A;

import java.util.Scanner;

public class CF9_D2_A {
    public static void main(String[] args) {
        // time reading 4 min
        // think 1 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int a = 7 - Math.max(y,w);
        int b = 6;
        for(int i = 1; i < 7;i++){
            if(a%i == 0&& b%i==0){
                a = a/i;
                b = b / i;
            }
        }
        System.out.println(String.format("%d/%d",a,b));
    }
}
