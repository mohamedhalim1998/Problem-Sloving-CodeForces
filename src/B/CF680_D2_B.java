package B;

import java.util.Scanner;

public class CF680_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 5 min
        // debug 3 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        a--;
        int[] cities = new int[n];
        for (int i = 0; i < n; i++) {
            cities[i] = scanner.nextInt();
        }
        int count = 0;
        if(cities[a] == 1){
            count++;
        }
        for (int i = 1, j = a -1 , k = a + 1; i < n; i++) {
            int numOfCriminals = 0;
            boolean thereTwoCities = true;
            if(j >= 0){
                if(cities[j] == 1){
                    numOfCriminals++;
                }
            } else {
                thereTwoCities = false;
            }

            if(k < n){
                if(cities[k] == 1){
                    numOfCriminals++;
                }
            } else {
                thereTwoCities = false;
            }

            if(thereTwoCities && numOfCriminals == 2){
                count+=2;
            }else if(numOfCriminals == 1 && !thereTwoCities){
                count++;
            }
            j--;
            k++;
        }

        System.out.println(count);
    }
}
