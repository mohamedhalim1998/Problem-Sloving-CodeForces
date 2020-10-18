package A;

import java.util.Scanner;

public class CF427_D2_A {
    public static void main(String[] args) {
        // reading time 2 min
        // think time 2 min
        // implement time 3 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int officers = 0;
        int untreated = 0;
        for(int i = 0;i < n ;i++){
            int event = scanner.nextInt();
            if(event == -1){
                if(officers > 0){
                    officers--;
                } else {
                    untreated++;
                }
            } else {
                officers += event;
            }
        }

        System.out.println(untreated);
    }
}
