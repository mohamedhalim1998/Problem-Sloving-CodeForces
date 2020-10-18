package A;

import java.util.Scanner;

public class CF268_D2_A {

    public static void main(String[] args) {
        // reading time 3 min
        // think time 5 min
        // implement time 4 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] host = new int[n];
        int[] guest = new int[n];
        for (int i = 0; i < n; i++) {
            host[i] = scanner.nextInt();
            guest[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(host[i] == guest[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }


}
