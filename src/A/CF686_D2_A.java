package A;

import java.util.Scanner;

public class CF686_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 4 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextInt();
        long dis = 0;
        for (int i = 0; i < n; i++) {
            if(scanner.next().charAt(0) == '+'){
                x += scanner.nextInt();
            } else {
                int d = scanner.nextInt();
                if(x >= d) {
                    x -= d;
                }else {
                    dis++;
                }
            }
        }

        System.out.println(x +" "+dis);
    }
}
